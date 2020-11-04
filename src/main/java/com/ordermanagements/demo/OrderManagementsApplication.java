package com.ordermanagements.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableTransactionManagement
@SpringBootApplication
@EnableSwagger2
public class OrderManagementsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
