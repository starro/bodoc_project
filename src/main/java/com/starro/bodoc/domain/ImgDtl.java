package com.starro.bodoc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by james@starroapp.com on 2019-07-31
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "IMG_DTL")
public class ImgDtl {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IMG_DTL_NO")
    private Long imgDtlNo;
    private String imgUrl;
    private String imgExpln;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMG_MGNT_NO")
    private ImgMgnt imgMgnt;

    @OneToMany(mappedBy = "imgDtl", cascade = CascadeType.ALL)
    private List<ImgHashtag> imgHashtagList = new ArrayList<ImgHashtag>();
}