package com.starro.bodoc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by james@starroapp.com on 2019-08-21
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
public class Hashtag {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "HASHTAG_NO")
    private Long hashtagNo;
    private String hashtag;

    @OneToMany(mappedBy = "hashtag")
    private List<ImgHashtag> imgHashtagList = new ArrayList<ImgHashtag>();
}
