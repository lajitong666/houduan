package com.example.plus;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Slf4j
//扫描dao层(也叫Mapper接口层,一个意思)
@MapperScan("com.example.plus.mapper")
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
  //注意一下，这个启动类有一个坑  由于springboot有内置的Tomcat 所以在部署项目到外置Tomcat时 会发生冲突  所以访问的时候会404

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
