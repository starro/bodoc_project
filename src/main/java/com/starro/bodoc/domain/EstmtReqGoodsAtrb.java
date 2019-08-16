package com.starro.bodoc.domain;

import javax.persistence.*;

/**
 * Created by james@starroapp.com on 2019-08-07
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "ESTMT_REQ_GOODS_ATRBT")
public class EstmtReqGoodsAtrb {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ESTMT_REQ_GOODS_ATRBT_NO")
    private Long estmtReqGoodsAtrbtNo;

    private String goodsMtrl;
    private String goodsMtrlPrpt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ESTMT_REQ_NO")
    private EstmtReqBase estmtReqBase;
}
