package com.atguigu.guli.service.base.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi") // 分组名称
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*"))) // 过滤相应前缀的路径
                .build();
    }

    @Bean
    public Docket adminApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }

    // 辅助方法，使用private即可
    // 用来定义swagger网页的文档描述
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("网站的API文档")
                .description("本文档描述了谷粒学院网站的api接口定义")
                .version("1.0")
                .contact(new Contact("sa", "http://atguigu.com", "@qq.com"))
                .build();
    }

    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("后台管理系统的API文档")
                .description("本文档描述了谷粒学院后台管理系统的api接口定义")
                .version("1.0")
                .contact(new Contact("sa", "http://atguigu.com", "@qq.com"))
                .build();
    }
}
