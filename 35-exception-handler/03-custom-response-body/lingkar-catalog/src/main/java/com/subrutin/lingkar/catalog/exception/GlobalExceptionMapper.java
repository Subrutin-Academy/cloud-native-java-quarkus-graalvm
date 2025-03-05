package com.subrutin.lingkar.catalog.exception;

import java.util.UUID;

import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import com.subrutin.lingkar.catalog.web.dto.ExceptionResponseDTO;

import io.quarkus.logging.Log;
import jakarta.ws.rs.core.Response;

public class GlobalExceptionMapper {

    @ServerExceptionMapper
    public RestResponse<ExceptionResponseDTO> mapException(ResourceNotFoundException ex){
        String errorId = UUID.randomUUID().toString();
        Log.error("Exception - Error Id"+errorId+":", ex);
        return RestResponse.status(Response.Status.NOT_FOUND, 
        new ExceptionResponseDTO(Integer.toString(Response.Status.NOT_FOUND.getStatusCode()), 
        "Error Id:"+errorId, ex.getMessage()));
    }

    @ServerExceptionMapper
    public RestResponse<String> mapException(RuntimeException ex){
        return RestResponse.status(Response.Status.BAD_REQUEST, ex.getMessage());
    }

}
