package com.starro.bodoc.controller;

import com.starro.bodoc.dto.EstmtReqBaseDTO;
import com.starro.bodoc.predicate.EstmtReqBasePredicate;
import com.starro.bodoc.service.EstmtReqBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.starro.bodoc.mapper.EstmtReqMapper.reqBaseMapper;
import static com.starro.bodoc.mapper.EstmtReqGoodsAtrbMapper.estmtReqGoodsMapper;

/**
 * Created by james@starroapp.com on 2019-10-13
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Api(description="최초 화면 로딩")
@RestController
@RequiredArgsConstructor
@RequestMapping("${property.api.end-point}")
public class EstmtReqController {
    private final EstmtReqBaseService estmtReqBaseService;

    @ApiOperation("목록")
    @GetMapping("/estmtReq")
    public Page<EstmtReqBaseDTO> getAll(@Valid EstmtReqBaseDTO estmtReqBaseDTO, @PageableDefault Pageable pageable){
        return estmtReqBaseService.getAll(EstmtReqBasePredicate.search(estmtReqBaseDTO), pageable).map(reqBaseMapper::toFindAll);
    }

    @ApiOperation("조회")
    @GetMapping("/estmtReq/{estmtReqNo}")
    public EstmtReqBaseDTO get(@PathVariable Long estmtReqNo){
        return reqBaseMapper.toFindOne(estmtReqBaseService.get(estmtReqNo));
    }

    @ApiOperation("등록")
    @PostMapping("/estmtReq")
    public EstmtReqBaseDTO add(@Valid @RequestBody EstmtReqBaseDTO estmtReqBaseDTO){
        return reqBaseMapper.toFindOne(estmtReqBaseService.add(reqBaseMapper.toEstmtReqBase(estmtReqBaseDTO), estmtReqGoodsMapper.toEstmtReqGoodsAtrbList(estmtReqBaseDTO.getEstmtReqGoodsAtrbList())));
    }

    @ApiOperation("수정")
    @PutMapping("/estmtReq/{estmtReqNo}")
    public EstmtReqBaseDTO modify(@PathVariable Long estmtReqNo, @Valid @RequestBody EstmtReqBaseDTO estmtReqBaseDTO){
        return reqBaseMapper.toFindOne(estmtReqBaseService.modify(estmtReqNo, reqBaseMapper.toEstmtReqBase(estmtReqNo, estmtReqBaseDTO)));
    }

    @ApiOperation("삭제")
    @DeleteMapping("/estmtReq/{estmtReqNo}")
    public void remove(@PathVariable Long estmtReqNo){
        estmtReqBaseService.remove(estmtReqNo);
    }
}