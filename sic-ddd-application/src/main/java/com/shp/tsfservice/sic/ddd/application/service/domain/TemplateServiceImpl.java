package com.shp.tsfservice.sic.ddd.application.service.domain;


import com.shp.tsfservice.sic.component.dto.SingleResponse;
import com.shp.tsfservice.sic.ddd.application.event.publish.TemplateEvent;
import com.shp.tsfservice.sic.ddd.application.transferUtil.TemplateTransferUtil;
import com.shp.tsfservice.sic.ddd.domain.template.TemplateDomainService;
import com.shp.tsfservice.sic.ddd.domain.template.aggerage.TemplateInfo;
import com.shp.tsfservice.sic.ddd.fegin.model.req.template.TemplateReq;
import com.shp.tsfservice.sic.ddd.io.interfaces.TemplateService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

@Service
@Validated
public class TemplateServiceImpl implements TemplateService {

    @Resource
    private TemplateDomainService templateDomainService;

    @Resource
    private TemplateEvent templateEvent;

    @Override
    public SingleResponse<Void> addTemplate(TemplateReq templateReq) {
        TemplateInfo templateInfo = TemplateTransferUtil.reqTransferInfo(templateReq);
        // 添加模板
        templateDomainService.addTemplate(templateInfo);
        // 发布添加模板事件
        templateEvent.publishTemplateAdd(templateInfo);
        return SingleResponse.buildSuccessWithNothing();
    }

}
