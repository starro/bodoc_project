package com.starro.bodoc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by james@starroapp.com on 2019-08-29
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Getter
@Setter
@Builder
@ToString(exclude = {"custInfoBaseDTO","estmtReqGoodsAtrbDTOList"})
@NoArgsConstructor
@AllArgsConstructor
public class EstmtReqBaseDTO {

    private Long estmtReqNo;
    private String estmtTyp;
    private String insrnceYn;
    private String wrntYn;
    private String aprslReqYn;
    private String pckupReqYn;
    private String promoNo;
    private String reqCntnt;
    private String goodsTyp;
    private String brndNm;
    private String modelNm;
    private String goodsExpln;

    @ApiModelProperty(value = "시작일시(형식:yyyy-MM-dd)")
    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startCreatedAt;

    @ApiModelProperty(value = "종료일시(형식:yyyy-MM-dd)")
    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endCreatedAt;

    private CustInfoBaseDTO custInfoBase;
    private List<EstmtReqGoodsAtrbDTO> estmtReqGoodsAtrbList;
}
