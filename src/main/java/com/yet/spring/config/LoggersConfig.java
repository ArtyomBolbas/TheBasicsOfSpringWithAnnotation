package com.yet.spring.config;


import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yet.spring.model.Event.EventType;
import com.yet.spring.model.logger.EventLogger;

import static com.yet.spring.model.Event.EventType.ERROR;
import static com.yet.spring.model.Event.EventType.INFO;

@Configuration
public class LoggersConfig {

	@Resource(name = "consoleEventLogger")
	private EventLogger consoleEventLogger;
	
	@Resource(name = "fileEventLogger")
	private EventLogger fileEventLogger;
	
	@Resource(name = "cacheEventLogger")
	private EventLogger cacheEventLogger;
	
	@Resource(name = "combinedEventLogger")
	private EventLogger combinedEventLogger;
	
	@Bean
	public Collection<EventLogger> combinedLoggers() {
		Collection<EventLogger> logger = new ArrayList<>();
		logger.add(consoleEventLogger);
		logger.add(fileEventLogger);
		return logger;
	}
	
	@Bean
	public Map<EventType, EventLogger> loggerMap() {
		Map<EventType, EventLogger> loggers = new EnumMap<>(EventType.class);
		loggers.put(INFO, consoleEventLogger);
		loggers.put(ERROR, combinedEventLogger);
		return loggers;
	}
	
	/*@Bean
	public EventLogger defaultLogger() {
		return cacheEventLogger;
	}*/
	
}
