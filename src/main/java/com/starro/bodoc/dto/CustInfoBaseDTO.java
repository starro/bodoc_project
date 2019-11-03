package com.starro.bodoc.dto;

import lombok.*;

/**
 * Created by james@starroapp.com on 2019-10-13
 *
 * @author StarroApp
 * @description
 ********************************************************************************/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustInfoBaseDTO {
    private Long custNo;
    private String password;
    private String custNm;
    private String nickNm;
}
