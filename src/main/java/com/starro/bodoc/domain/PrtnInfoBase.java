package com.starro.bodoc.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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
@Getter
@ToString(exclude = {"estmtList", "resrvList", "prtnAssmtList", "refrnces", "imgMgnt"})
@EqualsAndHashCode(exclude = {"estmtList", "resrvList", "prtnAssmtList", "refrnces", "imgMgnt"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PrtnInfoBase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "PRTN_NO")
    private Long prtnNo;
    private String password;
    private String bizNo;
    /**
     * 업체명
     */
    @Column(name = "PRTN_NM", length = 100, nullable = false)
    private String prtnNm;
    private String reprsntNm;
    private String custInchargeNm;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "ZIP_CODE", length = 5)),
            @AttributeOverride(name = "address", column = @Column(name = "ADDRESS", length = 200, nullable = false)),
            @AttributeOverride(name = "detailAddress", column = @Column(name = "DETAIL_ADDRESS", length = 200))
    })
    private Address address;
    /**
     * 대표번호
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phoneNo", column = @Column(name = "REPRSNT_NO", length = 20, nullable = false))
    })
    private Phone reprsntNo;
    /**
     * 모바일번호
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phoneNo", column = @Column(name = "MOBILE_NO", length = 20, nullable = false))
    })
    private Phone mobileNo;
    private String grntAvailYn;
    private String pckupAvailYn;
    private String purchsAvailYn;
    private String resetAvailYn;
    private String creatAvailYn;
    private String wdngDealYn;
    private String aprslAvailYn;
    private String prtnKwrd;
    private String prtnIntroCntnt;
    private float ratings;
    private String actvYn;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

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
