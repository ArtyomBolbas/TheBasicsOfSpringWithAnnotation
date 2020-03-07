package com.yet.spring.util.aware;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class AwareBean implements ApplicationContextAware, 
								BeanNameAware, 
								ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher eventPublisher;
	private String name;
	private ApplicationContext ctx;
	
	@PostConstruct
	public void init() {
		System.out.println(this.getClass().getSimpleName() + " > My name is '" + name + "'");
		if (ctx != null) {
			System.out.println(this.getClass().getSimpleName() + " > My context is " + ctx.getClass().toString());
		} else {
			System.out.println(this.getClass().getSimpleName() + " > Context is not set");
		}
		if (eventPublisher != null) {
			System.out.println(this.getClass().getSimpleName() + " > My eventPublisher is " + eventPublisher.getClass().toString());
		} else {
			System.out.println(this.getClass().getSimpleName() + " > EventPublisher is not set");
		}
	}
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}

	@Override
	public void setBeanName(String name) {
		this.name = name;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
	
}
