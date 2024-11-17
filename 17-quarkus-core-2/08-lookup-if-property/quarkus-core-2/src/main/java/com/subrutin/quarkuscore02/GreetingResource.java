package com.subrutin.quarkuscore02;

import com.subrutin.quarkuscore02.service.GreetingService;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    Instance<GreetingService> greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.get().sayHi();
    }
}
