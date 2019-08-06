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
@Table(name = "ITEM_CURNT_STATUS")
public class ItemCurntStatus {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;        //단순시퀀스
    private Long shopperId;
    private String shopperTyp;
    private String itemTyp;
    private BigDecimal itmeCurntPoint; //POSTGRES에서는 Numeric으로
    private String itemCntnt;
}
