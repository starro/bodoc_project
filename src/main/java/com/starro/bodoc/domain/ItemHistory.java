package com.starro.bodoc.domain;

import lombok.*;
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
@Table(name = "ITEM_HISTORY")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;        //단순시퀀스
    private String feeCalcMethod;
    private Long estmtReqNo;
    private Long shopperId;
    private String shopperTyp;
    private String itemChangeTyp;
    private String itemTyp;
    private BigDecimal changePoint;
    private String changeCntnt;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;
}
