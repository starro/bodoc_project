package com.starro.bodoc.form;

import com.starro.bodoc.dto.EstmtReqGoodsAtrbDTO;
import lombok.*;

import java.util.List;

/**
 * Created by james@starroapp.com on 2019-10-13
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
public class EstmtReqForm {
    public static class Request {
        @Getter
        @Setter
        @Builder
        @ToString(exclude = {"custInfoBase", "imgMgnt", "estmtReqGoodsAtrbList", "estmtList"})
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Find {
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

            private List<EstmtReqGoodsAtrbDTO> estmtReqGoodsAtrbDTOList;
        }

        @Getter
        @Setter
        @Builder
        @ToString(exclude = {"custInfoBase", "imgMgnt", "estmtReqGoodsAtrbList", "estmtList"})
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

            private List<EstmtReqGoodsAtrbDTO> estmtReqGoodsAtrbDTOList;
        }

    }

    public static class Response {

    }
}
