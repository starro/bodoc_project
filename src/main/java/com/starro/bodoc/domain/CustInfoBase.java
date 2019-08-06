package com.starro.bodoc.domain;

import javax.persistence.*;

/**
 * Created by james@starroapp.com on 2019-08-06
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "CUST_INFO_BASE")
public class CustInfoBase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CUST_NO")
    private Long custNo;
    private String password;
    private String custNm;
    private String nickNm;
    private String mobileNo;
    private String email;
    private String socialNo;
    private String socialTyp;
    private String socialImgUrl;
    private String actvYn;
}
