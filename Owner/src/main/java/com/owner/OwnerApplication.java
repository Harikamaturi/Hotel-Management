package com.owner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="com.owner.feignclient")

public class OwnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwnerApplication.class, args);
	}

}
