package com.starro.bodoc.repository;

import com.starro.bodoc.domain.ImgHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by james@starroapp.com on 2019-08-22
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Repository
public interface ImgHashtagRepository extends JpaRepository<ImgHashtag, Long>, QuerydslPredicateExecutor<ImgHashtag> {

}
