package com.shp.tsfservice.sic.ddd.application.transferUtil;

import com.shp.tsfservice.sic.ddd.domain.template.aggerage.TemplateInfo;
import com.shp.tsfservice.sic.ddd.fegin.model.req.template.TemplateReq;
import org.springframework.beans.BeanUtils;

public class TemplateTransferUtil {

    /**
     * TemplateReq -> TemplateInfo
     */
    public static TemplateInfo reqTransferInfo(TemplateReq templateReq) {
        TemplateInfo templateInfo = new TemplateInfo();
        BeanUtils.copyProperties(templateReq, templateInfo);
        return templateInfo;
    }

}
