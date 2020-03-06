package com.yet.spring.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yet.spring.service.logger.EventLogger;

@Configuration
public class LoggersConfig {

	@Resource(name = "consoleEventLogger")
	private EventLogger consoleEventLogger;
	
	@Bean
	public EventLogger defaultLogger() {
		return consoleEventLogger;
	}
	
}
