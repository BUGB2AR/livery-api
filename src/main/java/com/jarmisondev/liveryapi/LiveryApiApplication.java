package com.jarmisondev.liveryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jarmisondev.liveryapi.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class LiveryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveryApiApplication.class, args);
	}

}
