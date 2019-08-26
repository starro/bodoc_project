package com.starro.bodoc.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by james@starroapp.com on 2019-08-21
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "COMMENT")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"commentNo"})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;
    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    //사례번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REFRNCE_NO")
    private Refrnce refrnce;


}
