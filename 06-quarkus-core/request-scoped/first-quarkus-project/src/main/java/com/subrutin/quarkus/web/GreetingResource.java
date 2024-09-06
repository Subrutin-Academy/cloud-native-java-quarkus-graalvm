package com.subrutin.quarkus.web;

import com.subrutin.quarkus.domain.Author;
import com.subrutin.quarkus.service.MyRequestScopedService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
	
	private Author author;
	
	@Inject
	private MyRequestScopedService injectedService;

	@Inject
	public void setAuthor(Author author) {
		this.author = author;
	}


	@GET @Path("counter")
    @Produces(MediaType.TEXT_PLAIN)
	public String helloCounter() {
		int counter = injectedService.getAndIncrementCounter();
		return "Hello from Quarkus REST, the counter is "+counter;
	}

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    
        return "Hello "+this.author.getName()+" from Quarkus REST, this is Tedy";
    }
	
	@PostConstruct
	void init() {
		System.out.println("GreetingResource constructued");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("GreetingResource destroyed");
	}
}
