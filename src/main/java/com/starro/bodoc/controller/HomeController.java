package com.starro.bodoc.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by james@starroapp.com on 2019-10-04
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Api(description="최초 화면 로딩")
@RestController
@RequiredArgsConstructor
@RequestMapping("${property.api.end-point}")
public class HomeController {
}
