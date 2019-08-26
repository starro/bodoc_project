package com.starro.bodoc.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by james@starroapp.com on 2019-08-07
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "PRTN_ASSMT")
@Getter
@ToString(exclude = {"custInfoBase", "prtnInfoBase", "estmt"})
@EqualsAndHashCode(exclude = {"custInfoBase", "prtnInfoBase", "estmt"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PrtnAssmt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRTN_ASSMT_NO")
    private Long prtnAssmtNo;
    private Long qltyGrd;
    private int kindnessGrd;
    private String prtnAssmtCntnt;
    private String prtnReply;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;
    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

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
