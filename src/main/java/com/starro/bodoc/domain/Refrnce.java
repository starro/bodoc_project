package com.starro.bodoc.domain;

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
@Table(name = "REFRNCE")
@Getter
@ToString(exclude = {"prtnInfoBase", "estmt", "imgMgnt", "Comments"})
@EqualsAndHashCode(exclude = {"prtnInfoBase", "estmt", "imgMgnt", "Comments"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Refrnce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REFRNCE_NO")
    private Long refrnceNo;
    private String refrnceTyp;
    private String refrnceStatus;
    private String refrnceExpln;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;
    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRTN_NO")
    private PrtnInfoBase prtnInfoBase;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ESTMT_NO")
    private Estmt estmt;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IMG_MGNT_NO")
    private ImgMgnt imgMgnt;

    @OneToMany(mappedBy = "refrnce")
    private List<Comment> Comments = new ArrayList<Comment>();

    @Builder
    public Refrnce(String refrnceTyp, String refrnceStatus, String refrnceExpln) {
        this.refrnceTyp = refrnceTyp;
        this.refrnceStatus = refrnceStatus;
        this.refrnceExpln = refrnceExpln;
    }
}
