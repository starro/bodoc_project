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
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;        //단순시퀀스
    private String receiptId;
    private String orderId;
    private String name;
    private BigDecimal price;
    private String unit;
    private String pg;
    private String method;
    private String pgName;
    private String methodName;
    private String paymentData;
    private String requestedAt;
    private String purchasedAt;
    private String status;
}
