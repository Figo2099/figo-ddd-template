package com.shp.tsfservice.sic.ddd.infra.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author yangrui
 * @description consul 自定义配置
 * @date 2023/7/10 10:16
 */
@Component
@RefreshScope
public class CustomConfigData {

    @Getter
    //Value("${message}")
    private String test;



}
