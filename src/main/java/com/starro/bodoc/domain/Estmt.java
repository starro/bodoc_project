package com.starro.bodoc.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private BigDecimal estmtPrice;
    private float expctPiriod;
    private String offrSrvce;
    private String estmtPrCntnt;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;
    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESTMT_REQ_NO")
    private EstmtReqBase estmtReqBase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRTN_NO")
    private PrtnInfoBase prtnInfoBase;

    @OneToOne(mappedBy = "estmt")
    private Resrv resrv;

    @OneToOne(mappedBy = "estmt")
    private PrtnAssmt prtnAssmt;

    @OneToOne(mappedBy = "estmt")
    private Refrnce refrnce;
}
