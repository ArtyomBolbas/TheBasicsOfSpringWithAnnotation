package com.yet.spring.service.event;

import org.springframework.stereotype.Service;

import com.yet.spring.model.Event.EventType;

import static com.yet.spring.model.Event.EventType.ERROR;
import static com.yet.spring.model.Event.EventType.INFO;

@Service
public class EventService {

	public boolean hasEventType(EventType eventType) {
		return eventType != null;
	}
	
	public boolean isEventTypeInfo(EventType eventType) {
		return hasEventType(eventType) && eventType == INFO;
	}
	
	public boolean isEventTypeError(EventType eventType) {
		return hasEventType(eventType) && eventType == ERROR;
	}
	
}
