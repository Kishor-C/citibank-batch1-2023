package com.citibank.citibankwalletservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CitibankWalletServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitibankWalletServiceApplication.class, args);
	}
	
	@LoadBalanced // Ribbon load balancer which uses instance-id and resolves the physical address
	@Bean // registers the object of RestTemplate in spring container so that we can use this object in other places
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// builder has a build() to create RestTemplate object
		return builder.build();
	}

}
