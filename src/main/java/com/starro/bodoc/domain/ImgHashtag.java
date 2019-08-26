package com.starro.bodoc.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by james@starroapp.com on 2019-08-21
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "IMG_HASHTAG")
@Getter
@ToString(exclude = {"imgDtl", "hashtag"})
@EqualsAndHashCode(exclude = {"imgDtl", "hashtag"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImgHashtag {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IMG_HASHTAG_NO")
    private Long imgHashtagNo;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMG_DTL_NO")
    private ImgDtl imgDtl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HASHTAG_NO")
    private Hashtag hashtag;
}
