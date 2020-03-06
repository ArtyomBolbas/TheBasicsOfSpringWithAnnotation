package com.yet.spring.service.experiment;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.yet.spring.model.Client;

@Service
public class Experiment {

	@Autowired
	private Client client;

	public Experiment() {
		super();
	}

	public Experiment(Client client) {
		super();
		this.client = client;
	}

	public void experimental() {
		System.out.println(client.toString());
	}

}
