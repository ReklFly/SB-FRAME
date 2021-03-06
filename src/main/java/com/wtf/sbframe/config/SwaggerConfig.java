package com.wtf.sbframe.config;

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

/**
 * @author wangtengfei
 * @since 2020/10/9 15:47
 */
    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {
        @Bean
        public Docket createRestApi() {


            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    //对根下所有路径监控
                    .paths(PathSelectors.any())
                    //不显示error接口地址
                    .paths(Predicates.not(PathSelectors.regex("/error.*")))
                    .build();
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("SB-FRAME")
                    .version("1.0")
                    .contact(new Contact("WTF","",""))
                    .build();
        }

    }

