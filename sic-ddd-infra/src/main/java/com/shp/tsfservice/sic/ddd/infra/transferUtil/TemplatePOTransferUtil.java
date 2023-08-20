package com.shp.tsfservice.sic.ddd.infra.transferUtil;

import com.shp.tsfservice.sic.ddd.domain.template.aggerage.TemplateInfo;
import com.shp.tsfservice.sic.ddd.infra.repo.mysql.po.TemplatePo;
import org.springframework.beans.BeanUtils;

public class TemplatePOTransferUtil {

    public static TemplatePo infoTransferPo(TemplateInfo templateInfo) {
        TemplatePo templatePo = new TemplatePo();
        BeanUtils.copyProperties(templateInfo,templatePo);
        return templatePo;
    }
}
