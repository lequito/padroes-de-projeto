package com.alex.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LabDioGofApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabDioGofApplication.class, args);
	}

}
