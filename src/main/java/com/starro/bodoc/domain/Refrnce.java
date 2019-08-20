package com.starro.bodoc.domain;

import javax.persistence.*;
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
public class Refrnce {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "REFRNCE_NO")
    private Long refrnceNo;
    private String handworkTyp;
    private String refrnceStatus;
    private String refrnceExpln;

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
}
