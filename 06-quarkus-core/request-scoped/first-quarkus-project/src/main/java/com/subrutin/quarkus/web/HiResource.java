package com.subrutin.quarkus.web;

import com.subrutin.quarkus.service.MyApplicationScopedService;
import com.subrutin.quarkus.service.MyDependentService;
import com.subrutin.quarkus.service.MyRequestScopedService;
import com.subrutin.quarkus.service.MySingletonService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hi")
public class HiResource {
	
	@Inject
	private MyRequestScopedService injectedService;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hi() {
		int counter = injectedService.getAndIncrementCounter();
		return "Hi from Quarkus, your counter ="+counter;
	}


	@PostConstruct
	void init() {
		System.out.println("HiResource constructued");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("HiResource destroyed");
	}
}
