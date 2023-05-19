package com.citibank.citibankapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class CitibankApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitibankApiGatewayApplication.class, args);
	}

}
