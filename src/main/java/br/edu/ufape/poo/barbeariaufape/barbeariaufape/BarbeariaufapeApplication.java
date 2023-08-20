package br.edu.ufape.poo.barbeariaufape.barbeariaufape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "negocio.basica")
@SpringBootApplication
public class BarbeariaufapeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbeariaufapeApplication.class, args);
	}

}
