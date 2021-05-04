package com.kashuba.onlinestore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Online-shop REST API")
                .contact(new Contact("Kiryl Kashuba",
                        "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                        "kashuba.kirya@gmail.com"))
                .description("Online-shop")
                .build();
    }
}


//This comment at the bottom is still useful to me, sorry.

//@Configuration
//public class SpringFoxConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
////                .apis(RequestHandlerSelectors.basePackage("controller"))
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Online-shop REST API")
//                .contact(new Contact("Kiryl Kashuba", "https://www.youtube.com/watch?v=dQw4w9WgXcQ", "kashuba.kirya@gmail.com"))
//                .description("Online-shop")
//                .build();
//    }
//}
