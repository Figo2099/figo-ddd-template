package com.shp.tsfservice.sic.ddd.io.interfaces;

import com.shp.tsfservice.sic.component.dto.SingleResponse;
import com.shp.tsfservice.sic.ddd.fegin.model.req.template.TemplateReq;

/**
 * @author yangrui
 * @description 描述
 * @date 2023/7/26 09:33
 */
public interface TemplateWebService {

    SingleResponse<String> test();
}
