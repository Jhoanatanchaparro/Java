package com.example.EjercicioAutonomo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.EjercicioAutonomo")
public class EjercicioAutonomoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioAutonomoApplication.class, args);
	}

}
