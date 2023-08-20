package com.shp.tsfservice.sic.ddd.infra.repo.redis;

import com.shp.tsfservice.sic.component.business.cache.RedisStoreDao;
import com.shp.tsfservice.sic.component.util.DsonUtil;
import com.shp.tsfservice.sic.ddd.domain.template.aggerage.TemplateInfo;
import com.shp.tsfservice.sic.ddd.infra.repo.redis.util.TemplateRedisKeyUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author yangrui
 * @description Template Redis
 * @date 2023/6/30 16:09
 */
@Repository
public class TemplateRedisRepo {

    @Resource
    private RedisStoreDao redisStoreDao;

    public void addTemplate(TemplateInfo templateInfo) {
        String key = TemplateRedisKeyUtil.getTemplate(templateInfo.getUid());
        redisStoreDao.hPutAll(key, DsonUtil.toMap(DsonUtil.toJSON(templateInfo)));
    }
}
