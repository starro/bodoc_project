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
@Table(name = "IMG_MGNT")
@Getter
@ToString(exclude = {"imgDtlList", "estmtReqBase", "prtnInfoBase", "refrnce"})
@EqualsAndHashCode(exclude = {"imgDtlList", "estmtReqBase", "prtnInfoBase", "refrnce"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImgMgnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMG_MGNT_NO")
    private Long imgMgntNo;
    private String srvceClsfy;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "imgMgnt")
    private List<ImgDtl> imgDtlList = new ArrayList<ImgDtl>();

    @OneToOne(mappedBy = "imgMgnt")
    private EstmtReqBase estmtReqBase;

    @OneToOne(mappedBy = "imgMgnt")
    private PrtnInfoBase prtnInfoBase;

    @OneToOne(mappedBy = "imgMgnt")
    private Refrnce refrnce;
}