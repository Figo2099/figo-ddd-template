package com.shp.tsfservice.sic.ddd.application;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.tsf.annotation.EnableTsf;


@SpringBootApplication(scanBasePackages = {"com.shp.tsfservice"})
@EnableFeignClients(basePackages = {"com.shp.tsfservice.*"})
@EnableTsf
@Slf4j
@MapperScan("com.shp.tsfservice.sic.ddd.infra.repo.mysql.mapper")
public class SicDDDApplication {

    public static void main(String[] args) {
        SpringApplication.run(SicDDDApplication.class, args);
    }


}
