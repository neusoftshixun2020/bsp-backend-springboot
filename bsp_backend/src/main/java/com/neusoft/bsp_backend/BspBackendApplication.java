package com.neusoft.bsp_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan({"com.neusoft.bsp_backend.*.mapper", "com.neusoft.bsp_backend.common.*.mapper"})
@SpringBootApplication
@EnableSwagger2
public class BspBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BspBackendApplication.class, args);
    }

}
