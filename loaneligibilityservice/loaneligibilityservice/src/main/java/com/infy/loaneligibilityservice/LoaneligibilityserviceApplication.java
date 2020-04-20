package com.infy.loaneligibilityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoaneligibilityserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoaneligibilityserviceApplication.class, args);
	}

}
