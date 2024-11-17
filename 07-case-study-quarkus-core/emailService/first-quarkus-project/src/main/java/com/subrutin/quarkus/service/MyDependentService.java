package com.subrutin.quarkus.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;

@Dependent
public class MyDependentService {

	private int counter =0;
	
	public int getAndIncrementCounter() {
		return counter++;
	}
	
	@PostConstruct
	void init() {
		System.out.println("MyDependentService constructed");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("MyDependentService destroyed");
	}
}
