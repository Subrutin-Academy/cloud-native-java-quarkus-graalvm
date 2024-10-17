package com.subrutin.quarkus.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class MyRequestScopedService {

	private int counter =0;
	
	public int getAndIncrementCounter() {
		return counter++;
	}
	
	@PostConstruct
	void init() {
		System.out.println("MyRequestScopedService constructed");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("MyRequestScopedService destroyed");
	}
}
