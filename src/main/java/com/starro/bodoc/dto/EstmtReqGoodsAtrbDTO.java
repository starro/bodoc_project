package com.starro.bodoc.dto;

import com.starro.bodoc.common.engine.validator.form.date.DateValidator;
import com.starro.bodoc.domain.CustInfoBase;
import com.starro.bodoc.domain.ImgMgnt;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

/**
 * Created by james@starroapp.com on 2019-08-31
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Data
public class EstmtReqGoodsAtrbDTO {

    private String goodsMtrl;
    private String goodsMtrlPrpt;
}
