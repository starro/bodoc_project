package com.starro.bodoc.mapper;

import com.starro.bodoc.domain.EstmtReqBase;
import com.starro.bodoc.domain.EstmtReqGoodsAtrb;
import com.starro.bodoc.dto.EstmtReqGoodsAtrbDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by james@starroapp.com on 2019-11-02
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EstmtReqGoodsAtrbMapper {
    EstmtReqGoodsAtrbMapper estmtReqGoodsMapper = Mappers.getMapper(EstmtReqGoodsAtrbMapper.class);


    //새로운 요청일 때 자식 리스트 생성 매퍼
    List<EstmtReqGoodsAtrb> toEstmtReqGoodsAtrbList(List<EstmtReqGoodsAtrbDTO> estmtReqGoodsAtrbDTOList);

    //영속화 되어있는 자식 리스트를 변경하는 매퍼
    @Mappings({
            @Mapping(target = "estmtReqGoodsAtrbtNo", ignore = true)
            , @Mapping(target = "createdAt", ignore = true)
    })
    EstmtReqGoodsAtrb modify(EstmtReqGoodsAtrb source, @MappingTarget EstmtReqGoodsAtrb target);
}
