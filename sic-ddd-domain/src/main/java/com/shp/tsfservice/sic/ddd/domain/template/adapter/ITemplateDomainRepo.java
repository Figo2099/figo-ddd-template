package com.shp.tsfservice.sic.ddd.domain.template.adapter;

import com.shp.tsfservice.sic.ddd.domain.template.aggerage.TemplateInfo;

/**
 * @author yangrui
 * @description 仓储层门面
 * @date 2023/7/11 11:41
 */
public interface ITemplateDomainRepo {
    void addTemplateInfo(TemplateInfo templateInfo);

}
