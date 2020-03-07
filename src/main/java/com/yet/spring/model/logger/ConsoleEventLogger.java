package com.yet.spring.model.logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yet.spring.model.Event;

@Component
public class ConsoleEventLogger extends AbstractLogger {
	
	@Override
	public void logEvent(Event event) {
		System.out.println(event.toString());
	}

	@Value("Console logger")
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
}
