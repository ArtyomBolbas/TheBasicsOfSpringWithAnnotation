package com.yet.spring.service.event;

import org.springframework.stereotype.Service;


import com.yet.spring.model.Event.EventType;

@Service
public class EventService {

	public boolean hasEventType(EventType eventType) {
		return eventType != null;
	}
	
	public boolean isEventTypeInfo(EventType eventType) {
		return hasEventType(eventType) && eventType == EventType.INFO;
	}
	
	public boolean isEventTypeError(EventType eventType) {
		return hasEventType(eventType) && eventType == EventType.ERROR;
	}
	
}
