package otus.moryakovdv.meteoinformation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan
/***Запуск SpringBoot приложения*/
public class WebApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(WebApplication.class, args);
	}


	
	
	
	
	
}
