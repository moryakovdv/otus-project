package otus.moryakovdv.meteohelpers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import otus.moryakovdv.meteohelpers.service.Md5Hasher;
import otus.moryakovdv.meteohelpers.service.PasswordHasher;
import otus.moryakovdv.meteohelpers.service.SHA256Hasher;
import otus.moryakovdv.meteohelpers.service.SHA512Hasher;

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
