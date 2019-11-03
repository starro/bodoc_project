package com.starro.bodoc.mapper;

import com.starro.bodoc.domain.EstmtReqBase;
import com.starro.bodoc.dto.EstmtReqBaseDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * Created by james@starroapp.com on 2019-10-13
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EstmtReqMapper {

    EstmtReqMapper reqBaseMapper = Mappers.getMapper(EstmtReqMapper.class);

    EstmtReqBase toEstmtReqBase(EstmtReqBaseDTO dto);

    EstmtReqBase toEstmtReqBase(Long id, EstmtReqBaseDTO dto);

    EstmtReqBaseDTO toFindOne(EstmtReqBase domain);

    EstmtReqBaseDTO toFindAll(EstmtReqBase domain);

    @Mappings({
            @Mapping(target = "estmtReqNo", ignore = true)
            , @Mapping(target = "estmtReqGoodsAtrbList", ignore = true)
            , @Mapping(target = "createdAt", ignore = true)
    })
    EstmtReqBase modify(EstmtReqBase source, @MappingTarget EstmtReqBase target);
}
