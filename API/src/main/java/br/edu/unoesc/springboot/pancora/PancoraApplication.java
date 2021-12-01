package br.edu.unoesc.springboot.pancora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@EnableWebMvc
public class PancoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(PancoraApplication.class, args);
	}

}
