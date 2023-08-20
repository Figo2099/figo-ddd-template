package com.shp.tsfservice.sic.ddd.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author zh
 * @descript 应用产品域 枚举配置
 * @date 2023/6/29 15:24
 **/
public class ProductEnums {

    /**
     * 校验业务
     **/
    @Getter
    @AllArgsConstructor
    public enum VerificationEnum {

        PRODUCT_AUTHORIZED("PRODUCT_AUTHORIZED", "产品是否已授权"),
        ;

        /**
         * 状态码
         */
        private String code;
        /**
         * 描述
         */
        private String desc;

        public static final VerificationEnum formCode(final String code) {
            Optional<VerificationEnum> first = findFirst(code);
            return first.isPresent() ? first.get() : null;
        }

        public static boolean haveCode(final String code){
            return findFirst(code).isPresent();
        }

        private static Optional<VerificationEnum> findFirst(final String code){
            return Arrays.stream(VerificationEnum.values()).filter(d -> code.equals(d.getCode())).findFirst();
        }

    }
}
