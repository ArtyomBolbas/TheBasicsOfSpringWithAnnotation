package com.yet.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yet.spring.service.ConsoleEventLogger;

@Configuration
public class LoggersConfig {

	@Bean
	public ConsoleEventLogger getConsoleEventLogger() {
		return new ConsoleEventLogger();
	}
	
}
