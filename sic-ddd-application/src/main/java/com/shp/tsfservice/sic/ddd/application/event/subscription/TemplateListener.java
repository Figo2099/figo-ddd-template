package com.shp.tsfservice.sic.ddd.application.event.subscription;

import com.shp.tsfservice.sic.ddd.common.event.TemplateBean;
import com.shp.tsfservice.sic.ddd.common.event.TemplateBeanEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听模板添加事件
 */
@Component
public class TemplateListener implements ApplicationListener<TemplateBeanEvent> {

    @Override
    public void onApplicationEvent(@NotNull TemplateBeanEvent event) {
        TemplateBean templateBean = event.getSource();
        // 执行后续逻辑
    }
}
