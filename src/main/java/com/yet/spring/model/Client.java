package com.yet.spring.model;

public class Client {

	private String id;
	private String fullName;
	private String greeting;

	public Client() {}
	
	public Client(String id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", fullName=" + fullName + ", greeting=" + greeting + "]";
	}
	
}
