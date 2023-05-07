package com.gaohan.case01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 开启对 Servlet 组件的支持
@SpringBootApplication
public class Case01Application {

    public static void main(String[] args) {
        SpringApplication.run(Case01Application.class, args);
    }

}
