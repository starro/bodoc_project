package com.starro.bodoc.domain;

import javax.persistence.*;

/**
 * Created by james@starroapp.com on 2019-08-07
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "RESRV")
public class Resrv {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "RESRV_NO")
    private Long resrvNo;
    private Long custNo;
    private String resrvNm;
    private String resrvDate;
    private String pckupYn;
    private String pckupPostNo;
    private String pckupLocatn;
    private String pckupLocatnDtl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUST_NO")
    private CustInfoBase custInfoBase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRTN_NO")
    private PrtnInfoBase prtnInfoBase;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESTMT_NO")
    private Estmt estmt;
}
