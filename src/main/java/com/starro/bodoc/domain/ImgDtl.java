package com.starro.bodoc.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by james@starroapp.com on 2019-07-31
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "IMG_DTL")
@Getter
@ToString(exclude = {"imgMgnt", "imgHashtagList"})
@EqualsAndHashCode(exclude = {"imgMgnt", "imgHashtagList"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImgDtl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMG_DTL_NO")
    private Long imgDtlNo;
    private String imgUrl;
    private String imgExpln;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMG_MGNT_NO")
    private ImgMgnt imgMgnt;

    @OneToMany(mappedBy = "imgDtl", cascade = CascadeType.ALL)
    private List<ImgHashtag> imgHashtagList = new ArrayList<ImgHashtag>();
}