package com.starro.bodoc.domain;

import javax.persistence.*;

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
    private Long custNo;
    private String estmtTyp;
    private String insrnceYn;
    private String wrntYn;
    private String aprslReqYn;
    private String pckupReqYn;
    private String promoNo;
    private String reqCntnt;
    private String goodsTyp;
    private String brndNm;
    private String imgMgntNo;
    private String modelNm;
    private String goodsExpln;
}
