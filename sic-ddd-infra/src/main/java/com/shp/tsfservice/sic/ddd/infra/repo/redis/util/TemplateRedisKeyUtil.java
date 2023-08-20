package com.shp.tsfservice.sic.ddd.infra.repo.redis.util;

/**
 * TemplateRedisKey 工具类
 */
public class TemplateRedisKeyUtil {


    /**
     * 获取申请单Code后缀
     */
    public static String getTemplate(String key) {
        return String.format("s:t:k:%s:info", key);
    }

}
