package com.shp.tsfservice.sic.ddd.io.api.internal;

import com.shp.tsfservice.sic.component.dto.SingleResponse;
import com.shp.tsfservice.sic.ddd.fegin.model.req.template.TemplateReq;
import com.shp.tsfservice.sic.ddd.io.interfaces.TemplateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 对接系统内部api
 */
@RestController
@RequestMapping("template")
public class TemplateApi {

    @Resource
    private TemplateService templateService;

    @ApiOperation("添加模板")
    @PostMapping("/add")
    public SingleResponse<Void> addTemplate(@RequestBody @Validated TemplateReq templateReq){
        return templateService.addTemplate(templateReq);
    }


}
