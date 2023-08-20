package com.shp.tsfservice.sic.ddd.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author zh
 * @descript 规则
 * @date 2023/7/5 14:34
 **/
public class RuleEnums {
    /**
     * @descript 规则
     **/
    @Getter
    @AllArgsConstructor
    @ToString
    public enum Rule{

        YYMMDD(Dimension.TIME,"YYMMdd", "年年月月日日"),
        ;

        private Dimension dimension;

        /**
         * 状态码
         */
        private String code;
        /**
         * 描述
         */
        private String desc;
    }

    /**
     * @descript 规则维度
     **/
    @Getter
    @AllArgsConstructor
    public enum Dimension{
        TIME("TIME", "时间"),
        ;
        /**
         * 状态码
         */
        private String code;
        /**
         * 描述
         */
        private String desc;
    }
}
