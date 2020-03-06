package com.yet.spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.yet.spring.model.Client;
import com.yet.spring.model.Event;
import com.yet.spring.service.logger.EventLogger;

import static com.yet.spring.util.EventMessages.EVENT_MESSAGE;
import static java.lang.String.format;


@Component
public class Application {
	
	@Autowired
	private Client client;

	@Resource(name = "defaultLogger")
	private EventLogger defaultLogger;
	
	@Resource(name = "fileEventLogger")
	private EventLogger fileEventLogger; 
	
	@Resource(name = "cacheEventLogger")
	private EventLogger cacheEventLogger;
	
	public Application() {}
	
	public Application(Client client, EventLogger cacheEventLogger) {
		super();
		this.client = client;
		this.cacheEventLogger = cacheEventLogger;
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
		app.logEvent(event, format(EVENT_MESSAGE, 1));
		
		event = ctx.getBean(Event.class);
		app.logEvent(event, format(EVENT_MESSAGE, 1));
		
		event = ctx.getBean(Event.class);
		app.logEvent(event, format(EVENT_MESSAGE, 1));
		
		event = ctx.getBean(Event.class);
		app.logEvent(event, format(EVENT_MESSAGE, 1));
		
		ctx.close();
	}
	
	private void logEvent(Event event, String msg) {
		String message = msg.replaceAll(client.getId(), client.getFullName());
		event.setMessage(message);
		
		cacheEventLogger.logEvent(event);
	}

	
}
 