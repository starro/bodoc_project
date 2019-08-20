package com.starro.bodoc.domain;

import javax.persistence.*;
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
public class ImgMgnt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IMG_MGNT_NO")
    private Long imgMgntNo;
    private String srvceClsfy;

    @OneToMany(mappedBy = "imgMgnt")
    private List<ImgDtl> imgDtlList = new ArrayList<ImgDtl>();

    @OneToOne(mappedBy = "imgMgnt")
    private EstmtReqBase estmtReqBase;

    @OneToOne(mappedBy = "imgMgnt")
    private PrtnInfoBase prtnInfoBase;

    @OneToOne(mappedBy = "imgMgnt")
    private Refrnce refrnce;
}