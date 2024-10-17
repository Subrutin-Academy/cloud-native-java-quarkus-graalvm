package com.subrutin.quarkus.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Singleton;

@Singleton
public class MySingletonService {

	private int counter =0;
	
	public int getAndIncrementCounter() {
		return counter++;
	}
	
	@PostConstruct
	void init() {
		System.out.println("MySingletonService constructed");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("MySingletonService destroyed");
	}
}
