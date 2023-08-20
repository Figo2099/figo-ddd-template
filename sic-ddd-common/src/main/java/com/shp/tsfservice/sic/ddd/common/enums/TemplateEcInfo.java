package com.shp.tsfservice.sic.ddd.common.enums;

import com.shp.tsfservice.sic.component.exception.IErrorInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum TemplateEcInfo implements IErrorInfo {

    ERROR("错误码code在com","错误"),

    ;

    /**
     * 错误码
     */
    private final String ec;
    /**
     * 错误描述
     */
    private final String em;
}
