package com.subrutin.lingkar.catalog.web;

import java.net.URI;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.AppUserService;
import com.subrutin.lingkar.catalog.web.dto.AppUserListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.AppUserRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/v1/app-user")
public class AppUserResource {

    private final AppUserService appUserService;

    public AppUserResource(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @POST
    public RestResponse<Void> createAppUser(@Valid AppUserRequestDTO dto) {
        this.appUserService.createAppUser(dto);
        return RestResponse.created(URI.create("/v1/app-user"));
    }

    @GET
    public RestResponse<ResultPageResponseDTO<AppUserListResponseDTO>> findAppUserlIst(
            @QueryParam("pages") @DefaultValue("0") Integer pages,
            @QueryParam("limit") @DefaultValue("10")  Integer limit,
            @QueryParam("sortBy") @DefaultValue("name")  String sortBy,
            @QueryParam("direction") @DefaultValue("asc")  String direction,
            @QueryParam("name") String name) {
        return RestResponse.ok(appUserService.findAppUserList(pages, limit, sortBy, direction, name));
    }
}
