package de.mehtrick.getraenkeautomaddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = {"de.mehtrick.getraenkeautomaddd.domain"})
@EnableJpaRepositories(basePackages = {"de.mehtrick.getraenkeautomaddd.facade"})
@EnableJpaAuditing
@EnableTransactionManagement
public class GetraenkeautomadddApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetraenkeautomadddApplication.class, args);
	}

}
