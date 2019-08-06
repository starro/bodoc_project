package com.starro.bodoc.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by james@starroapp.com on 2019-08-07
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "ESTMT")
public class Estmt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ESTMT_NO")
    private Long estmtNo;
    private Long estmtReqNo;
    private Long prtnNo;
    private BigDecimal estmtPrice;
    private float expctPiriod;
    private String offrSrvce;
    private String estmtPrCntnt;
}
