package com.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingServiceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceMicroserviceApplication.class, args);
	}

}
