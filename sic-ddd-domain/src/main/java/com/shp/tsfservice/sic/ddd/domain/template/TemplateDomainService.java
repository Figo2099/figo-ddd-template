package com.shp.tsfservice.sic.ddd.domain.template;

import com.shp.tsfservice.sic.ddd.domain.template.adapter.ITemplateDomainRepo;
import com.shp.tsfservice.sic.ddd.domain.template.aggerage.TemplateInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 模版领域逻辑
 */
@Service
public class TemplateDomainService {

    @Resource
    private ITemplateDomainRepo templateDomainRepo;

    public void addTemplate(TemplateInfo templateInfo){
        templateDomainRepo.addTemplateInfo(templateInfo);
    }

}
