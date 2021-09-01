package com.dio.live.swagger;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ParameterBuilder;

@Configuration
@EnableSwagger2
public class swaggerConfig {
    @Bean
    public Docket apiAdmin(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dio.live"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(
                        Collections.singletonList(
                                new ParameterBuilder()
                                .name("Authorization")
                                .description("Header para Token JWT")
                                .modelRef(new ModelRef("string"))
                                .required(false)
                                .build()
                        )
                );
    }
    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API-REST")
                .description("Api_para_gerenciamento_de_ponto_e_acesso")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org.licenses/LICENCE-2.0")
                .contact(new Contact("DIO","https://webdigitalinnocation.one","contato@digitalinnovationone.com.br"))
                .build();
    }
}
