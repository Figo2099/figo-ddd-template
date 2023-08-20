package com.shp.tsfservice.sic.ddd.io.api.external;


import com.shp.tsfservice.sic.component.dto.SingleResponse;
import com.shp.tsfservice.sic.ddd.io.interfaces.TemplateWebService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 对接web端api
 */
@RestController
@RequestMapping("/web/template")
public class TemplateWebApi {

    @Resource
    private TemplateWebService templateWebService;

    @ApiOperation("添加模板")
    @PostMapping("/api")
    public SingleResponse<String> test(){
        return templateWebService.test();
    }

}
