package toll.management.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "toll.management.controller, toll.management.service, toll.management.model")
@EnableJpaRepositories("toll.management.dao")
@EntityScan("toll.management.model")
public class TollManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollManagementApplication.class, args);
	}

}
