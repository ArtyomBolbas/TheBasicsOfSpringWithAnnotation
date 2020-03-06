package com.yet.spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.yet.spring.config.AppConfig;
import com.yet.spring.model.Client;
import com.yet.spring.model.Event;
import com.yet.spring.service.logger.EventLogger;

@Component
public class Application {
	
	@Autowired
	private Client client;

	@Resource(name = "defaultLogger")
	private EventLogger defaultLogger;
	
	public Application() {}
	
	public Application(Client client, EventLogger defaultLogger) {
		super();
		this.client = client;
		this.defaultLogger = defaultLogger;
	}
	
	public static void main(String[] args) {		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.scan("com.yet.spring*");
		ctx.refresh();
		
		Application app = ctx.getBean("application", Application.class);
		
		//Client client = ctx.getBean(Client.class);
		System.out.println(app.client.getGreeting());
		
		Event event = ctx.getBean(Event.class);
		app.logEvent(event, "Some event for 1");
		
		ctx.close();
	}
	
	private void logEvent(Event event, String msg) {
		String message = msg.replaceAll(client.getId(), client.getFullName());
		event.setMessage(message);
		
		defaultLogger.logEvent(event);
	}

	
}
 