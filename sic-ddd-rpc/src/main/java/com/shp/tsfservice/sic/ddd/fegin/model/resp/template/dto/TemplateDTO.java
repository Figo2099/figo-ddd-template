package com.shp.tsfservice.sic.ddd.fegin.model.resp.template.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yangrui
 * @description 描述
 * @date 2023/7/26 10:05
 */
@Data
public class TemplateDTO implements Serializable {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("名称")
    private String name;

}
