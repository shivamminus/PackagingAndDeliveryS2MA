package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class PackagingAndDeliveryS2MaApplication {

	public static void main(String[] args) {
        System.setProperty("server.connection-timeout","60000");
		SpringApplication.run(PackagingAndDeliveryS2MaApplication.class, args);
	}

}
