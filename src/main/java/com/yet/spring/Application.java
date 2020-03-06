package com.yet.spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.yet.spring.model.Client;
import com.yet.spring.model.Event;
import com.yet.spring.model.Event.EventType;
import com.yet.spring.service.logger.EventLogger;

import static com.yet.spring.model.Event.EventType.ERROR;
import static com.yet.spring.model.Event.EventType.INFO;
import static com.yet.spring.util.EventMessages.EVENT_MESSAGE;

import static java.lang.String.format;

import java.util.Map;


@Component
public class Application {
	
	@Autowired
	private Client client;

	@Resource(name = "cacheEventLogger")
	private EventLogger defaultLogger;
	
	@Resource(name = "loggerMap")
	private Map<EventType, EventLogger> loggers;
	
	public Application() {}
	
	public Application(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggerMap) {
		super();
		this.client = client;
		this.defaultLogger = defaultLogger;
		this.loggers = loggerMap;
	}
	
	public static void main(String[] args) {		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//ctx.register(AppConfig.class, LoggerConfig.class);
		ctx.scan("com.yet.spring*");
		ctx.refresh();
		
		Application app = ctx.getBean("application", Application.class);
		
		//Client client = ctx.getBean(Client.class);
		System.out.println(app.client.getGreeting());
		
		Event event = ctx.getBean(Event.class);
		app.logEvent(INFO, event, format(EVENT_MESSAGE, 1));
		
		event = ctx.getBean(Event.class);
		app.logEvent(ERROR, event, format(EVENT_MESSAGE, 1));
		
		event = ctx.getBean(Event.class);
		app.logEvent(INFO, event, format(EVENT_MESSAGE, 1));
		
		event = ctx.getBean(Event.class);
		app.logEvent(null, event, format(EVENT_MESSAGE, 1));
		
		ctx.close();
	}
	
	private void logEvent(EventType eventType, Event event, String msg) {
		String message = msg.replaceAll(client.getId(), client.getFullName());
		event.setMessage(message);
		
		EventLogger logger = loggers.get(eventType);
		if (logger == null) {
			logger = defaultLogger;
		}
		
		logger.logEvent(event);
	}

	
}
 