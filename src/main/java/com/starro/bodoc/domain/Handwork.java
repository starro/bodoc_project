package com.starro.bodoc.domain;

import javax.persistence.*;

/**
 * Created by james@starroapp.com on 2019-08-07
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "HANDWORK")
public class Handwork {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "HANDWORK_NO")
    private Long handworkNo;
    private Long estmtNo;
    private Long prtnNo;
    private String handworkTyp;
    private Long imgMgntNo;
    private String handworkStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRTN_NO")
    private PrtnInfoBase prtnInfoBase;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESTMT_NO")
    private Estmt estmt;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IMG_MGNT_NO")
    private ImgMgnt imgMgnt;
}
