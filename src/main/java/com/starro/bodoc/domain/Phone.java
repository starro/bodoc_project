package com.starro.bodoc.domain;

import lombok.Builder;

import javax.persistence.Embeddable;

/**
 * Created by james@starroapp.com on 2019-08-26
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Embeddable
@Builder
public class Phone {

    private String phoneNo;
}
