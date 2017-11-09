package com.nicolas.bookshare.bookshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2
@EnableWebMvc
@Import(SpringDataRestConfiguration.class)
public class BookshareApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshareApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nicolas.bookshare.bookshare"))
				.paths(PathSelectors.any())
				.build();
	}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Bookshare API")
                .description("API RESTful para o Bookshare")
                .version("1.0")
                .build();
    }
}
