package com.yet.spring.service.logger;

import org.springframework.stereotype.Component;

import com.yet.spring.model.Event;

@Component
public class ConsoleEventLogger implements EventLogger{
	
	@Override
	public void logEvent(Event event) {
		System.out.println(event.toString());
	}

}
