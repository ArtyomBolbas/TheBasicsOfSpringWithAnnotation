package com.yet.spring.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
	
	private int id;
	private String message;
	private Date date;
	private DateFormat df;

	private Random generator = new Random();
	
	public Event() {}
	
	public Event(Date date) {
		this.date = date;
	}
	
	public Event(Date date, DateFormat df) {
		super();
		this.id = generator.nextInt();
		this.date = date;
		this.df = df;
	}
	
	public static boolean hasEventType(EventType eventType) {
		return eventType != null;
	}
	
	public static boolean isEventTypeInfo(EventType eventType) {
		return hasEventType(eventType) && eventType.equals(EventType.INFO);
	}
	
	public static boolean isEventTypeError(EventType eventType) {
		return hasEventType(eventType) && eventType.equals(EventType.ERROR);
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
