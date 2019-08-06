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
@Table(name = "ITEM_HISTORY")
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
}
