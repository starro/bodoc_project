package com.starro.bodoc.domain;

import javax.persistence.*;

/**
 * Created by james@starroapp.com on 2019-07-31
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "IMG_DTL")
public class ImgDtl {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IMG_DTL_NO")
    private Long imgDtlNo;
    private Long imgMgntNo;
    private String imgUrl;
    private String imgExpln;
}