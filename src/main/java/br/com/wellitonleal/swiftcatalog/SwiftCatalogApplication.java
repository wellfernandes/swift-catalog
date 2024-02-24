package br.com.wellitonleal.swiftcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SwiftCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiftCatalogApplication.class, args);
	}

}
