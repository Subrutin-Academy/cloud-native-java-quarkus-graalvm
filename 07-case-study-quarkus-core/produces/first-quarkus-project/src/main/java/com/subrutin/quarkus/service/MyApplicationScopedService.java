package com.subrutin.quarkus.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyApplicationScopedService {

	private int counter =0;
	
	public int getAndIncrementCounter() {
		return counter++;
	}
	
	@PostConstruct
	void init() {
		System.out.println("MyApplicationScopedService constructed");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("MyApplicationScopedService destroyed");
	}
}
