package com.infy.auditservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket loanApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.infy.auditservice.controller"))
//				.paths(PathSelectors.ant("/loandetails/*"))
				.build().apiInfo(apiInfo());
	}
	
	public ApiInfo apiInfo() {
		ApiInfo apiInfomation=new ApiInfo("Loan Details API", "Loan Details API Info", "1.0", "", new Contact("Srujan Kumar", "", "srujankumar.r@infosys.com"), "", "");
		return apiInfomation;
	}
}
