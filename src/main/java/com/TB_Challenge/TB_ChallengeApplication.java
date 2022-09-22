package com.TB_Challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TB_ChallengeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		System.out.println("http://localhost:8080/");
		SpringApplication.run(TB_ChallengeApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TB_ChallengeApplication.class);
	}
}
