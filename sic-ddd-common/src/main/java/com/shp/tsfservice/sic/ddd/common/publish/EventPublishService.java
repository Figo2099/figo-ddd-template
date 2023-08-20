package com.shp.tsfservice.sic.ddd.common.publish;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class EventPublishService implements ApplicationContextAware {

    /**
     * spring 容器
     */
    private ApplicationContext applicationContext;


    /**
     * 初始化spring 容器对象
     * @param applicationContext the ApplicationContext object to be used by this object
     * @throws BeansException 初始化失败则抛出异常
     */
    @Override
    public void setApplicationContext( ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 发布事件
     * @param event 事件信息
     */
    public void publishEvent(ApplicationEvent event){
        applicationContext.publishEvent(event);
    }

}