package com.starro.bodoc.service;

import com.querydsl.core.types.Predicate;
import com.starro.bodoc.domain.EstmtReqBase;
import com.starro.bodoc.domain.EstmtReqGoodsAtrb;
import com.starro.bodoc.mapper.EstmtReqGoodsAtrbMapper;
import com.starro.bodoc.mapper.EstmtReqMapper;
import com.starro.bodoc.repository.EstmtReqBaseRepository;
import com.starro.bodoc.repository.EstmtReqGoodsAtrbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by james@starroapp.com on 2019-10-09
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Service
@Transactional
@RequiredArgsConstructor
public class EstmtReqBaseService {
    private final EstmtReqBaseRepository estmtRepository;
    private final EstmtReqGoodsAtrbRepository estmtReqGoodsAtrbRepository;

    @Transactional(readOnly = true)
    public Page<EstmtReqBase> getAll(Predicate predicate, Pageable pageable) {
        return estmtRepository.findAll(predicate, pageable);
    }

    @Transactional(readOnly = true)
    public EstmtReqBase get(Long id) {
        return estmtRepository.getOne(id);
    }

    public EstmtReqBase add(EstmtReqBase estmtReqBase, List<EstmtReqGoodsAtrb> estmtReqGoodsAtrbList) {

        //연관관계 맺기
        for (EstmtReqGoodsAtrb estmtReqGoodsAtrb : estmtReqGoodsAtrbList) {
            estmtReqGoodsAtrb.setEstmtReqBase(estmtReqBase);
        }

        //위의 연관 관계 다시 맵핑
        estmtReqBase.setEstmtReqGoodsAtrbList(estmtReqGoodsAtrbList);

        EstmtReqBase reqBase = estmtRepository.save(estmtReqBase);

        return reqBase;
    }

    public EstmtReqBase modify(Long id, EstmtReqBase estmtReqBase) {
        List<EstmtReqGoodsAtrb> orignalList = estmtReqGoodsAtrbRepository.findByEstmtReqBase(get(id));

        for (EstmtReqGoodsAtrb orignal : orignalList) {
            List<EstmtReqGoodsAtrb> modList = estmtReqBase.getEstmtReqGoodsAtrbList();
            for (EstmtReqGoodsAtrb mod : modList) {
                if (mod.getEstmtReqGoodsAtrbtNo().equals(orignal.getEstmtReqGoodsAtrbtNo())) {
                    EstmtReqGoodsAtrbMapper.estmtReqGoodsMapper.modify(mod, orignal);
                }
            }
        }
        estmtReqBase.setEstmtReqGoodsAtrbList(orignalList);

        return EstmtReqMapper.reqBaseMapper.modify(estmtReqBase, get(id));
    }

    public void remove(Long id) {
        estmtRepository.delete(get(id));
    }
}
