package io.github.jassonluiz.unibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"io.github.jassonluiz.unibank.model.entity"})
@SpringBootApplication
public class UnibankApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnibankApplication.class, args);
	}

}
