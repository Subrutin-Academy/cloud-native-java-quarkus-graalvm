package com.subrutin.lingkar.catalog.web;

import java.net.URI;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.PublisherService;
import com.subrutin.lingkar.catalog.web.dto.PublisherCreateRequestDTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/v1/publishers")
public class PublisherResource {

    private final PublisherService publisherService;

    
    @Inject
    public PublisherResource(PublisherService publisherService) {
        this.publisherService = publisherService;
    }



    @POST
    public RestResponse<Void> createPublisher(PublisherCreateRequestDTO dto){
        publisherService.createPublisher(dto);
        return RestResponse.created(URI.create("/v1/publishers"));
    }

}
