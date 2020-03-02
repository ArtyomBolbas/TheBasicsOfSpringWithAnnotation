package com.yet.spring.config;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.yet.spring.model.Client;

@Configuration
@PropertySource("classpath:properties/client.properties")
public class AppConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public Date newDate() {
		return new Date();
	}
	
	@Bean
	public DateFormat dateFormate() {
		return DateFormat.getDateTimeInstance();
	}
	
	@Bean
	public Client client() {
		Client client = new Client();
		client.setId(environment.getRequiredProperty("id"));
		client.setFullName(environment.getRequiredProperty("name"));
		client.setGreeting(environment.getProperty("greeting"));
		return client;
	}
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyConfigIn() {
		return new PropertyPlaceholderConfigurer();
	}
	
}
