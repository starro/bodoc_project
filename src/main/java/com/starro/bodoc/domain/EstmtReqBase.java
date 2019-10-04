package com.starro.bodoc.domain;

import com.starro.bodoc.dto.EstmtReqGoodsAtrbDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by james@starroapp.com on 2019-08-07
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "ESTMT_REQ_BASE")
@Getter
@ToString(exclude = {"custInfoBase", "imgMgnt", "estmtReqGoodsAtrbList", "estmtList"})
@EqualsAndHashCode(exclude = {"custInfoBase", "imgMgnt", "estmtReqGoodsAtrbList", "estmtList"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EstmtReqBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESTMT_REQ_NO")
    private Long estmtReqNo;
    private String estmtTyp;
    private String insrnceYn;
    private String wrntYn;
    private String aprslReqYn;
    private String pckupReqYn;
    private String promoNo;
    private String reqCntnt;
    private String goodsTyp;
    private String brndNm;
    private String modelNm;
    private String goodsExpln;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUST_NO")
    private CustInfoBase custInfoBase;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IMG_MGNT_NO")
    private ImgMgnt imgMgnt;

    @OneToMany(mappedBy = "estmtReqBase", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<EstmtReqGoodsAtrb> estmtReqGoodsAtrbList = new ArrayList<EstmtReqGoodsAtrb>();

    @OneToMany(mappedBy = "estmtReqBase")
    private List<Estmt> estmtList = new ArrayList<Estmt>();

    @Builder
    public EstmtReqBase(String estmtTyp, String insrnceYn, String wrntYn, String aprslReqYn, String pckupReqYn,
                        String promoNo, String reqCntnt, String goodsTyp, String brndNm, String modelNm, String goodsExpln) {
        this.estmtTyp = estmtTyp;
        this.insrnceYn = insrnceYn;
        this.wrntYn = wrntYn;
        this.aprslReqYn = aprslReqYn;
        this.pckupReqYn = pckupReqYn;
        this.promoNo = promoNo;
        this.reqCntnt = reqCntnt;
        this.goodsTyp = goodsTyp;
        this.brndNm = brndNm;
        this.modelNm = modelNm;
        this.goodsExpln = goodsExpln;
    }

    public void setCustInfoBase(CustInfoBase custInfoBase) {
        this.custInfoBase = custInfoBase;
        custInfoBase.getEstmtReqBaseList().add(this);
    }

    public void addEstmtReqGoodsAtrb(EstmtReqGoodsAtrbDTO estmtReqGoodsAtrbDTO) {
        this.estmtReqGoodsAtrbList.add(buildAtrb(estmtReqGoodsAtrbDTO));
    }

    private EstmtReqGoodsAtrb buildAtrb(EstmtReqGoodsAtrbDTO estmtReqGoodsAtrbDTO) {
        return EstmtReqGoodsAtrb.builder()
                .goodsMtrl(estmtReqGoodsAtrbDTO.getGoodsMtrl())
                .goodsMtrlPrpt(estmtReqGoodsAtrbDTO.getGoodsMtrlPrpt())
                .estmtReqBase(this)
                .build();
    }
}
