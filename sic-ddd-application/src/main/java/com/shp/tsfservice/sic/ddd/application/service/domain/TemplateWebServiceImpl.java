package com.shp.tsfservice.sic.ddd.application.service.domain;

import com.shp.tsfservice.sic.component.dto.SingleResponse;

import com.shp.tsfservice.sic.ddd.fegin.model.req.template.TemplateReq;
import com.shp.tsfservice.sic.ddd.io.interfaces.TemplateService;
import com.shp.tsfservice.sic.ddd.io.interfaces.TemplateWebService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yangrui
 * @description 描述
 * @date 2023/7/26 09:34
 */
@Service
public class TemplateWebServiceImpl implements TemplateWebService {

    @Override
    public SingleResponse<String> test() {
        return SingleResponse.of("success");
    }
}
