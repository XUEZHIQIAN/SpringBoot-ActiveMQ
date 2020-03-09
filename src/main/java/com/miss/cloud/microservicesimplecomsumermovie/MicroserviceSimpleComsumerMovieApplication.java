package com.miss.cloud.microservicesimplecomsumermovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@PropertySource(value = {"classpath:application.properties"})
@ImportResource(value = {"classpath:spring-application.xml"})
public class MicroserviceSimpleComsumerMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleComsumerMovieApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
