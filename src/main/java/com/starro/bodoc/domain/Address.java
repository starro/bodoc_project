package com.starro.bodoc.domain;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by james@starroapp.com on 2019-08-26
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Embeddable
@Builder
public class Address {

    private String zipCode;
    private String address;
    private String detailAddress;

}
