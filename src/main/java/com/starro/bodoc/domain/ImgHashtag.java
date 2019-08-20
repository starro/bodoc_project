package com.starro.bodoc.domain;

import javax.persistence.*;

/**
 * Created by james@starroapp.com on 2019-08-21
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
public class ImgHashtag {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "IMG_HASHTAG_NO")
    private Long imgHashtagNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMG_DTL_NO")
    private ImgDtl imgDtl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HASHTAG_NO")
    private Hashtag hashtag;
}
