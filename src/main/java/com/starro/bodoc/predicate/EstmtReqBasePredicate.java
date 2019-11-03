package com.starro.bodoc.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.starro.bodoc.domain.QEstmtReqBase;
import com.starro.bodoc.dto.EstmtReqBaseDTO;
import com.starro.bodoc.sample.api.entity.QSample;
import com.starro.bodoc.sample.api.form.SampleForm;

import java.util.Optional;

/**
 * Created by james@starroapp.com on 2019-10-15
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
public class EstmtReqBasePredicate {
    public static Predicate search(EstmtReqBaseDTO estmtReqBaseDTO) {

        QEstmtReqBase estmtReqBase  = QEstmtReqBase.estmtReqBase;
        BooleanBuilder builder = new BooleanBuilder();

        Optional.ofNullable(estmtReqBaseDTO.getCustInfoBase().getCustNo()).ifPresent(p -> builder.and(estmtReqBase.custInfoBase.custNo.eq(p)));

        return builder;
    }
}
