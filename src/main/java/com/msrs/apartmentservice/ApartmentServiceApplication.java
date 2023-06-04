package com.msrs.apartmentservice;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApartmentServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApartmentServiceApplication.class, args);
	}
}
