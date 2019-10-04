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
@Table(name = "CUST_INFO_BASE")
@Getter
@ToString(exclude = {"estmtReqBaseList", "prtnAssmtList", "resrvList"})
@EqualsAndHashCode(exclude = {"estmtReqBaseList", "prtnAssmtList", "resrvList"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustInfoBase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CUST_NO")
    private Long custNo;
    private String password;
    private String custNm;
    private String nickNm;
    /**
     * 모바일번호
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phoneNo", column = @Column(name = "MOBILE_NO", length = 20, nullable = false))
    })
    private Phone mobileNo;
    /**
     * 이메일
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "email", column = @Column(name = "EMAIL", nullable = false))
    })
    private Email email;
    private String socialNo;
    private String socialTyp;
    private String socialImgUrl;
    private String refreshToken;

    @Column(name = "ACTIVE_YN", length = 1)
    @Enumerated(EnumType.STRING)
    private ActivYn actvYn;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;
    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "custInfoBase")
    private List<EstmtReqBase> estmtReqBaseList = new ArrayList<EstmtReqBase>();

    @OneToMany(mappedBy = "custInfoBase")
    private List<PrtnAssmt> prtnAssmtList = new ArrayList<PrtnAssmt>();

    @OneToMany(mappedBy = "custInfoBase")
    private List<Resrv> resrvList = new ArrayList<Resrv>();

    @Builder
    public CustInfoBase(String password, String custNm, String nickNm, Phone mobileNo, Email email, String socialNo,
                        String socialTyp, String socialImgUrl, String refreshToken, ActivYn actvYn) {
        this.password = password;
        this.custNm = custNm;
        this.nickNm = nickNm;
        this.mobileNo = mobileNo;
        this.email = email;
        this.socialNo = socialNo;
        this.socialTyp = socialTyp;
        this.socialImgUrl = socialImgUrl;
        this.refreshToken = refreshToken;
        this.actvYn = actvYn;
    }

    public enum ActivYn {
        Y,N
    }
}
