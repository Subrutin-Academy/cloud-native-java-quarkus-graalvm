package com.subrutin.lingkar.catalog.exception;

import java.util.UUID;

import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import com.subrutin.lingkar.catalog.web.dto.ExceptionResponseDTO;

import io.quarkiverse.resteasy.problem.HttpProblem;
import io.quarkus.logging.Log;
import jakarta.ws.rs.core.Response;

public class GlobalExceptionMapper {

    @ServerExceptionMapper
    public RestResponse<HttpProblem> mapException(ResourceNotFoundException ex){
        String errorId = UUID.randomUUID().toString();
        Log.error("Exception - Error Id"+errorId+":", ex);
        HttpProblem problem = HttpProblem.builder()
            .withTitle(Response.Status.NOT_FOUND.name())
            .withDetail("Error Id:"+errorId+" "+ex.getMessage())
            .withStatus(Response.Status.NOT_FOUND).build();
        return RestResponse.status(Response.Status.NOT_FOUND, 
        problem);
    }

    @ServerExceptionMapper
    public RestResponse<HttpProblem> mapException(RuntimeException ex){
        String errorId = UUID.randomUUID().toString();
        Log.error("Exception - Error Id"+errorId+":", ex);
        HttpProblem problem = HttpProblem.builder()
            .withTitle(Response.Status.BAD_REQUEST.name())
            .withDetail("Error Id:"+errorId+" "+ex.getMessage())
            .withStatus(Response.Status.BAD_REQUEST).build();
        return RestResponse.status(Response.Status.BAD_REQUEST, problem);
    }

}
