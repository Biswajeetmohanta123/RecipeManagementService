package com.geekster.RecipeManagementService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class RecipeManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeManagementServiceApplication.class, args);
	}

}
