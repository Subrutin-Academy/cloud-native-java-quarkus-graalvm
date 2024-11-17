package com.subrutin.quarkus;

import com.subrutin.quarkus.domain.Author;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Author author = new Author();
        author.setName("Karen Armstrong");
        return "Hello "+ author.getName() +" from Quarkus REST, this is Tedy";
    }
}
