package com.starro.bodoc.dto;

import com.starro.bodoc.common.engine.validator.form.date.DateValidator;
import com.starro.bodoc.domain.CustInfoBase;
import com.starro.bodoc.domain.ImgMgnt;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by james@starroapp.com on 2019-08-29
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
public class EstmtReqBaseDTO {
    public static class Request {

        @Getter
        @Setter
        @Builder
        @ToString(exclude = {"custInfoBase", "imgMgnt", "estmtReqGoodsAtrbList", "estmtList"})
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Find {

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

            @ApiModelProperty(value="시작일시(형식:yyyy-MM-dd)")
            @PastOrPresent
            @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
            private LocalDate startCreatedAt;

            @ApiModelProperty(value="종료일시(형식:yyyy-MM-dd)")
            @PastOrPresent
            @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
            private LocalDate endCreatedAt;

            @AssertTrue
            public boolean isValidDateRange() {
                return DateValidator.isValidDateRange(startCreatedAt, endCreatedAt);
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Add {

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
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Modify {

        }
    }

    public static class Response {

        @Data
        public static class FindAll {


        }

        @Data
        public static class FindOne {

        }
    }
}
