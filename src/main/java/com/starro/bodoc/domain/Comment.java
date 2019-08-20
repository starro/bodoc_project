package com.starro.bodoc.domain;

import javax.persistence.*;

/**
 * Created by james@starroapp.com on 2019-08-21
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "COMMENT_NO")
    private Long commentNo;
    private Long grpNo;
    private Long parentCommentNo;
    private Long grpLayer;
    private int commentOrd;
    private String cntnt;
    private String userTyp;
    private Long userNo;
    private String entityTyp;

    //사례번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REFRNCE_NO")
    private Refrnce refrnce;
}
