package com.starro.bodoc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "PRTN_NO")
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
    private String prtnIntroCntnt;
    private String actvYn;

    @OneToMany(mappedBy = "prtnInfoBase")
    private List<Estmt> estmtList = new ArrayList<Estmt>();

    @OneToMany(mappedBy = "prtnInfoBase")
    private List<Resrv> resrvList = new ArrayList<Resrv>();

    @OneToMany(mappedBy = "prtnInfoBase")
    private List<PrtnAssmt> prtnAssmtList = new ArrayList<PrtnAssmt>();

    @OneToMany(mappedBy = "prtnInfoBase")
    private List<Refrnce> refrnces = new ArrayList<Refrnce>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IMG_MGNT_NO")
    private ImgMgnt imgMgnt;
}
