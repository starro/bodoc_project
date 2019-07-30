package com.starro.bodoc.domain;

import javax.persistence.*;

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

}