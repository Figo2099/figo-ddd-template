package com.shp.tsfservice.sic.ddd.io.interfaces;

import com.shp.tsfservice.sic.component.dto.SingleResponse;
import com.shp.tsfservice.sic.ddd.fegin.model.req.template.TemplateReq;

public interface TemplateService {
    SingleResponse<Void> addTemplate(TemplateReq templateReq);

}
