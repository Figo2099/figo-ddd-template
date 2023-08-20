package com.shp.tsfservice.sic.ddd.application.event.publish;

import com.shp.tsfservice.sic.ddd.common.event.TemplateBean;
import com.shp.tsfservice.sic.ddd.common.event.TemplateBeanEvent;
import com.shp.tsfservice.sic.ddd.common.publish.EventPublishService;
import com.shp.tsfservice.sic.ddd.domain.template.aggerage.TemplateInfo;
import com.shp.tsfservice.sic.ddd.infra.config.CustomConfigData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class TemplateEvent {

    @Resource
    private EventPublishService eventPublishService;

    @Resource
    private CustomConfigData customConfigData;

    /**
     * 添加模板时间
     *
     * @param templateInfo 模板
     */
    public void publishTemplateAdd(TemplateInfo templateInfo) {
        TemplateBean templateBean = new TemplateBean();
        BeanUtils.copyProperties(templateInfo, templateBean);
        Object test = customConfigData.getTest();
        eventPublishService.publishEvent(new TemplateBeanEvent(templateBean));
    }

}
