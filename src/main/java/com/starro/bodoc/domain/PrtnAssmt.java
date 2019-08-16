package com.starro.bodoc.domain;

import javax.persistence.*;

/**
 * Created by james@starroapp.com on 2019-08-07
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "PRTN_ASSMT")
public class PrtnAssmt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "PRTN_ASSMT_NO")
    private Long prtnAssmtNo;
    private Long estmtNo;
    private Long prtnNo;
    private Long custNo;
    private Long qltyGrd;
    private int kindnessGrd;
    private String prtnAssmtCntnt;
    private String prtnReply;

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
