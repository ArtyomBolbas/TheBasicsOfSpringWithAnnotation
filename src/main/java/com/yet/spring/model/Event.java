package com.yet.spring.model;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Event {
	
	private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
	
	private int id;
	private String message;
	
	@Autowired
	@Qualifier("newDate")
	private Date date;
	
	@Autowired
	private DateFormat df;
	
	public Event() {
		this.id = AUTO_ID.getAndIncrement();
	}
	
	public Event(Date date) {
		this.date = date;
	}
	
	public Event(Date date, DateFormat df) {
		this();
		this.date = date;
		this.df = df;
	}
	
	public static boolean isEvenMinutes() {
		LocalTime time = LocalTime.now();
		return time.getMinute() % 2 == 0 ? true : false;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "id=" + id + ", message=" + message + ", date=" + df.format(date) + System.lineSeparator();
	}
	
	public enum EventType {
		INFO,
		ERROR
	}
	
}
