package com.yet.spring.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yet.spring.service.logger.EventLogger;

@Configuration
public class LoggersConfig {

	@Resource(name = "consoleEventLogger")
	private EventLogger consoleEventLogger;
	
	@Resource(name = "fileEventLogger")
	private EventLogger fileEventLogger;
	
	@Resource(name = "cacheEventLogger")
	private EventLogger cacheEventLogger;
	
	@Bean
	public EventLogger defaultLogger() {
		return consoleEventLogger;
	}
	
}
