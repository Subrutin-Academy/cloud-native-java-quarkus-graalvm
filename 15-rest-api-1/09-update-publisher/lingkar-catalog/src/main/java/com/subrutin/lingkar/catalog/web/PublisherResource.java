package com.subrutin.lingkar.catalog.web;

import java.net.URI;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.PublisherService;
import com.subrutin.lingkar.catalog.web.dto.PublisherCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherUpdateRequestDTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

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
    
    //GET v1/publisher/{id}
    @GET
    @Path("{id}")
    public RestResponse<PublisherDetailResponseDTO> findPublisherDetail(@PathParam("id") Long id){
        PublisherDetailResponseDTO dto = publisherService.findPublisher(id);
        return RestResponse.ok(dto);

    }

    //PUT v1/publishers/{id}
    @PUT
    @Path("{id}")
    public RestResponse<Void> updatePublisher(@PathParam("id") Long id, PublisherUpdateRequestDTO dto) {
        publisherService.updatePublisher(id, dto);
        return RestResponse.ok();
    } 

}
