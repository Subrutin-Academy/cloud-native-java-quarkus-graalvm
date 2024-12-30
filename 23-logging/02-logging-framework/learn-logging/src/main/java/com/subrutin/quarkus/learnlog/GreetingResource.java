package com.subrutin.quarkus.learnlog;

import java.util.logging.Logger;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    // java.util.logging.Logger julLogger = java.util.logging.Logger.getLogger(GreetingResource.class.getName());
    // org.jboss.logging.Logger jbossLogger = org.jboss.logging.Logger.getLogger(GreetingResource.class);
    // org.slf4j.Logger slf4jLogger =org.slf4j.LoggerFactory.getLogger(GreetingResource.class);
    // org.apache.commons.logging.Log commonsLogger = org.apache.commons.logging.LogFactory.getLog(GreetingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Log.info("this is from quarkus log");
        // julLogger.info("this is from JUL Logger");
        // jbossLogger.info("this is from JBoss Logger");
        // slf4jLogger.info("this from slf4 log");
        // commonsLogger.info("this is from Apache Commons Log");
        return "Hello from Quarkus REST";
    }
}
