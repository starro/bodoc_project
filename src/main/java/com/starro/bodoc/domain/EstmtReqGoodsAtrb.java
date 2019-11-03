package com.starro.bodoc.domain;

import com.rabbitmq.client.LongString;
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
@Table(name = "ESTMT_REQ_GOODS_ATRBT")
@Setter
@Getter
@ToString(exclude = {"estmtReqBase"})
@EqualsAndHashCode(exclude = {"estmtReqBase"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EstmtReqGoodsAtrb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESTMT_REQ_GOODS_ATRBT_NO")
    private Long estmtReqGoodsAtrbtNo;

    private String goodsMtrl;
    private String goodsMtrlPrpt;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "ESTMT_REQ_NO", nullable = false, updatable = false)
    private EstmtReqBase estmtReqBase;

    @Builder
    public EstmtReqGoodsAtrb(String goodsMtrl, String goodsMtrlPrpt, EstmtReqBase estmtReqBase) {
        this.goodsMtrl = goodsMtrl;
        this.goodsMtrlPrpt = goodsMtrlPrpt;
        this.estmtReqBase = estmtReqBase;
    }
}
