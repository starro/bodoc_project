package com.starro.bodoc.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by james@starroapp.com on 2019-08-21
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Entity
@Table(name = "HASHTAG")
@Getter
@ToString(exclude = {"imgHashtagList"})
@EqualsAndHashCode(exclude = {"imgHashtagList"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hashtag {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "HASHTAG_NO")
    private Long hashtagNo;
    private String hashtag;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "hashtag")
    private List<ImgHashtag> imgHashtagList = new ArrayList<ImgHashtag>();
}
