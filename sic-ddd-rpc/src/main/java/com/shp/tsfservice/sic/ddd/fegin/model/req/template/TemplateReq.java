package com.shp.tsfservice.sic.ddd.fegin.model.req.template;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class TemplateReq implements Serializable {

    @ApiModelProperty("姓名")
    @NotBlank(message = "name is not blank")
    private String name;

}
