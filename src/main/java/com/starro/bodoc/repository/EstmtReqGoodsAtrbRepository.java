package com.starro.bodoc.repository;

import com.starro.bodoc.domain.EstmtReqBase;
import com.starro.bodoc.domain.EstmtReqGoodsAtrb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by james@starroapp.com on 2019-08-22
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Repository
public interface EstmtReqGoodsAtrbRepository extends JpaRepository<EstmtReqGoodsAtrb, Long>, QuerydslPredicateExecutor<EstmtReqGoodsAtrb> {
    List<EstmtReqGoodsAtrb> findByEstmtReqBase(EstmtReqBase estmtReqBase);
    EstmtReqGoodsAtrb findByEstmtReqGoodsAtrbtNo(Long estmtReqGoodsAtrbtNo);
}
