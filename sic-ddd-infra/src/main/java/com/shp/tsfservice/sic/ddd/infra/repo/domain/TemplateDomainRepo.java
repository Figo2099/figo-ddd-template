package com.shp.tsfservice.sic.ddd.infra.repo.domain;

import com.shp.tsfservice.sic.ddd.domain.template.adapter.ITemplateDomainRepo;
import com.shp.tsfservice.sic.ddd.domain.template.aggerage.TemplateInfo;
import com.shp.tsfservice.sic.ddd.infra.repo.mysql.mapper.TemplateMapper;
import com.shp.tsfservice.sic.ddd.infra.repo.mysql.po.TemplatePo;
import com.shp.tsfservice.sic.ddd.infra.repo.redis.TemplateRedisRepo;
import com.shp.tsfservice.sic.ddd.infra.transferUtil.TemplatePOTransferUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yangrui
 * @description 模版仓储领域
 * @date 2023/7/11 09:43
 */
@Component
public class TemplateDomainRepo implements ITemplateDomainRepo {

    @Resource
    private TemplateMapper templateMapper;

    @Resource
    private TemplateRedisRepo templateRedisRepo;

    @Override
    public void addTemplateInfo(TemplateInfo templateInfo) {
        TemplatePo templatePo = TemplatePOTransferUtil.infoTransferPo(templateInfo);
        //templateMapper.insert(templatePo);
        templateRedisRepo.addTemplate(templateInfo);
    }
}
