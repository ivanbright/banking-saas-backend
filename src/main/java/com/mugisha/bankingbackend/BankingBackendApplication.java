package com.mugisha.bankingbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.mugisha.bankingbackend.model")
public class BankingBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankingBackendApplication.class, args);
	}

}
