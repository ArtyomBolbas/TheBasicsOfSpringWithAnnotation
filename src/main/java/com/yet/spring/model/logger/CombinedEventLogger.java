package com.yet.spring.model.logger;

import java.util.Collection;
import java.util.Collections;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yet.spring.model.Event;

@Component
public class CombinedEventLogger extends AbstractLogger {

	@Resource(name = "combinedLoggers")
	private Collection<EventLogger> loggers;
	
	@Override
	public void logEvent(Event event) {
		loggers.stream()
			.forEach(eventLogger -> eventLogger.logEvent(event));
	}
	
	public Collection<EventLogger> getLoggers() {
		return Collections.unmodifiableCollection(loggers);
	}
	
	@Value("#{'Combined ' + combinedEventLogger.loggers.![name].toString()}")
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
}
