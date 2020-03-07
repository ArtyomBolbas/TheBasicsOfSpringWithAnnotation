package com.yet.spring.model.logger;

import com.yet.spring.model.Event;

public interface EventLogger {

	void logEvent(Event event);
	
	String getName();
	
}
