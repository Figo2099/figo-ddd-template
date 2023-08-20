package com.shp.tsfservice.sic.ddd.common.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yangrui
 * @description 超级管理员邀请事件
 * @date 2023/6/25 10:12
 */
public class TemplateBeanEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public TemplateBeanEvent(TemplateBean source) {
        super(source);
    }

    @Override
    public TemplateBean getSource() {
        return (TemplateBean) super.getSource();
    }
}
