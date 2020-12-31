package com.test.firstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableEurekaClient
//@EnableCircuitBreaker
@EnableSwagger2
public class FirstspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstspringbootApplication.class, args);
	}

}
