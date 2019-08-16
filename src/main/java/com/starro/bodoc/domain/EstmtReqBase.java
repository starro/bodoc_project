package com.starro.bodoc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by james@starroapp.com on 2019-08-07
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "ESTMT_REQ_BASE")
public class EstmtReqBase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ESTMT_REQ_NO")
    private Long estmtReqNo;
    private String estmtTyp;
    private String insrnceYn;
    private String wrntYn;
    private String aprslReqYn;
    private String pckupReqYn;
    private String promoNo;
    private String reqCntnt;
    private String goodsTyp;
    private String brndNm;
    private String modelNm;
    private String goodsExpln;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUST_NO")
    private CustInfoBase custInfoBase;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IMG_MGNT_NO")
    private ImgMgnt imgMgnt;

    @OneToMany(mappedBy = "estmtReqBase")
    private List<EstmtReqGoodsAtrb> estmtReqGoodsAtrbList = new ArrayList<EstmtReqGoodsAtrb>();

    @OneToMany(mappedBy = "estmtReqBase")
    private List<Estmt> estmtList = new ArrayList<Estmt>();
}
