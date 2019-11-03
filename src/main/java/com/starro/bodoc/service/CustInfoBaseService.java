package com.starro.bodoc.service;

import com.starro.bodoc.repository.CustInfoBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by james@starroapp.com on 2019-10-09
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Service
@Transactional
@RequiredArgsConstructor
public class CustInfoBaseService {
    private final CustInfoBaseRepository custInfoBaseRepository;
}
