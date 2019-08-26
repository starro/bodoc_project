package com.starro.bodoc.repository;

import com.querydsl.core.types.Predicate;
import com.starro.bodoc.domain.CustInfoBase;
import com.starro.bodoc.domain.QCustInfoBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import  static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by james@starroapp.com on 2019-08-22
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustInfoBaseRepositoryTest {

    @Autowired
    CustInfoBaseRepository custInfoBaseRepository;

    @Test
    public void crud(){
        QCustInfoBase custInfoBase = QCustInfoBase.custInfoBase;
        Predicate predicate = QCustInfoBase.custInfoBase
                .custNm.containsIgnoreCase("sanghoon")
                .and(custInfoBase.actvYn.equalsIgnoreCase("N"));

        Optional<CustInfoBase> custOne = custInfoBaseRepository.findOne(predicate);
        assertThat(custOne).isEmpty();
    }

}
