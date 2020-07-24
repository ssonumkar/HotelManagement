package com.example.HoteldB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HoteldBApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HoteldBApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HoteldBApplication.class);
	}
}
