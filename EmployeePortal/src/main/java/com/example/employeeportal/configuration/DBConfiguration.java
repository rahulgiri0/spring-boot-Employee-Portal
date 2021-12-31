package com.example.employeeportal.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("datasource")
public class DBConfiguration {

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		System.out.println(driverClassName);
		return "DB connection for DEV";
	}

	@Profile("prod")
	@Bean
	public String prodDatabaseConnection() {
		System.out.println(driverClassName);
		return "DB connection for PROD";
	}
}
