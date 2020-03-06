package com.yet.spring.service.logger;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yet.spring.model.Event;

@Component
public class CombinedEventLogger implements EventLogger {

	@Resource(name = "combinedLoggers")
	private Collection<EventLogger> loggers;
	
	@Override
	public void logEvent(Event event) {
		loggers.stream()
			.forEach(eventLogger -> eventLogger.logEvent(event));
	}
	
}
