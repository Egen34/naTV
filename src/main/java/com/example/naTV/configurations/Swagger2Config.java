package com.example.naTV.configurations;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2Config  {
    public static final String CHANNELS="каналы";
    public static final String DAY="дни";
    public static final String ORDERS="заказы";
    public static final String ORDERDETAIL="детали заказов";
    public static final String PRICE="цены";
    public static final String DISCOUNT="скидки";
    @Bean
    public Docket api2() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("crud")
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.naTV.controller.crud"))
                .build()
                .tags(new Tag(CHANNELS,""))
                .tags(new Tag(ORDERS,""))
                .tags(new Tag(ORDERDETAIL,""))
                .tags(new Tag(PRICE,""))
                .tags(new Tag(DAY,""))
                .tags(new Tag(DISCOUNT,""))
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket api1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.naTV.controller.defaults"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(CHANNELS,""))
                .tags(new Tag(ORDERS,""))
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("natv.kg")
                .description("Размешения рекламы")
                .build();
    }


}