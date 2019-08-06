package com.starro.bodoc.domain;

import javax.persistence.*;

/**
 * Created by james@starroapp.com on 2019-08-06
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "PRTN_INFO_BASE")
public class PrtnInfoBase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CUST_NO")
    private Long prtnNo;
    private String password;
    private String bizNo;
    private String prtnNm;
    private String reprsntNm;
    private String custInchargeNm;
    private String postNo;
    private String addr;
    private String dtlAddr;
    private String telNo;
    private String mobileNo;
    private String grntAvailYn;
    private String pckupAvailYn;
    private String purchsAvailYn;
    private String resetAvailYn;
    private String creatAvailYn;
    private String wdngDealYn;
    private String aprslAvailYn;
    private String prtnKwrd;
    private String imgMgntNo;
    private String prtnIntroCntnt;
    private String actvYn;
}
