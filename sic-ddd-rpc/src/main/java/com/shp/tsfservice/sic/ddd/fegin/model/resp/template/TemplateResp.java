package com.shp.tsfservice.sic.ddd.fegin.model.resp.template;

import com.shp.tsfservice.sic.ddd.fegin.model.resp.template.dto.TemplateDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yangrui
 * @description 描述
 * @date 2023/7/26 10:04
 */
@Data
public class TemplateResp implements Serializable {

    @ApiModelProperty("模版信息")
    private TemplateDTO templateDTO;

}
