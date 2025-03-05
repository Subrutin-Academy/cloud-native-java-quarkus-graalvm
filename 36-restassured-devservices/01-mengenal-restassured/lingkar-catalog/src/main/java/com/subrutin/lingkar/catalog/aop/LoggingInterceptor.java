package com.subrutin.lingkar.catalog.aop;

import io.quarkus.logging.Log;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Logged
@Interceptor
@Priority(1)
public class LoggingInterceptor {

    @AroundInvoke
    Object logInvocation(InvocationContext context) throws Exception {

        //code will be executed before target method executed
        long start = System.currentTimeMillis();
        Log.info("***** Starting *****"+context.getTarget().getClass().getName()
        + " " +  context.getMethod().getName() );
        //target method executed
        Object ret = context.proceed();

        //code will be executed after target method executed
        long end = System.currentTimeMillis();
        Log.info("***** Completed *****"+context.getTarget().getClass().getName()
        + " " +  context.getMethod().getName() +
        "("+ (end-start)+")");

        return ret;
        
    }

}
