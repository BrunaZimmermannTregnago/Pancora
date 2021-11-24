package br.edu.unoesc.springboot.pancora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
public class PancoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(PancoraApplication.class, args);
	}

}
