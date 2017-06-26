package com.lenovo.logapp.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserManApp {

	public static void main(String[] args) {
		SpringApplication.run(UserManApp.class, args);
	}
}
