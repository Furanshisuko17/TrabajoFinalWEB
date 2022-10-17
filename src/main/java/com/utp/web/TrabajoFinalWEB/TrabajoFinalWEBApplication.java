package com.utp.web.TrabajoFinalWEB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config/mysql/db.properties")
public class TrabajoFinalWEBApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoFinalWEBApplication.class, args);
	}

}
