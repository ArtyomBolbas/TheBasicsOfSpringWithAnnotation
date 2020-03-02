package com.yet.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.yet.spring.config.AppConfig;
import com.yet.spring.model.Client;

@Component
public class Application {
	
	@Autowired
	private Client client;

	public Application() {}
	
	public Application(Client client) {
		super();
		this.client = client;
	}
	
	public static void main(String[] args) {		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.scan("com.yet.spring");
		ctx.refresh();
		
		Application application = ctx.getBean("application", Application.class);
		Experiment experiment = ctx.getBean("experiment", Experiment.class);
		experiment.experimental();
		System.out.println(application.client.getGreeting());
		
		ctx.close();
	}

	
}
 