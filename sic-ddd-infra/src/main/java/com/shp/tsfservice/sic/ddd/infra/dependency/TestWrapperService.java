package com.shp.tsfservice.sic.ddd.infra.dependency;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 服务rpc调用
 */
@FeignClient(name = "sic-test")
public interface TestWrapperService {

}
