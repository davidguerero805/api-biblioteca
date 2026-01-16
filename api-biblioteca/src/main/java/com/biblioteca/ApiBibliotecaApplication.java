package com.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Esta anotación activa el escaneo de componentes, la autoconfiguración y más.
public class ApiBibliotecaApplication {

	public static void main(String[] args) {
		// Este método inicia toda la magia de Spring Boot
		SpringApplication.run(ApiBibliotecaApplication.class, args);
	}

}
