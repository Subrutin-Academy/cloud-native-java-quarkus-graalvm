package com.subrutin.lingkar.catalog.web;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import com.subrutin.lingkar.catalog.web.dto.AppUserRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.ProfileRequestDTO;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class AppUserResourceTest {

	@Test
	public void createAppUser_Success() {
		ProfileRequestDTO profileDTO = new ProfileRequestDTO(
				20321L, "Jalan Merdeka", "64117");
		AppUserRequestDTO appUserDTO = new AppUserRequestDTO(
				"tedy","+62-81234567891", "detik19@gmail.com", profileDTO);
		
       given()
	        .contentType(MediaType.APPLICATION_JSON)
	        .accept(MediaType.APPLICATION_JSON)
	        .body(appUserDTO)
        .when()
        .post("/v1/app-user")
        	.then()
        .statusCode(200);				
		
	}
	
	//update app user
	@Test
	public void updateAppUser_Success() {
		ProfileRequestDTO profileDTO = new ProfileRequestDTO(
				20321L, "Jalan Merdeka", "64117");
		AppUserRequestDTO appUserDTO = new AppUserRequestDTO(
				"tedy","+62-81234567891", "detik19@gmail.com", profileDTO);
		
       given()
	        .contentType(MediaType.APPLICATION_JSON)
	        .accept(MediaType.APPLICATION_JSON)
            .body(appUserDTO)
        .when()
        .put("/v1/app-user/f47ac10b-58cc-4372-a567-0e02b2c3d479")
            .then()
        .statusCode(200);				
		
	}

	@Test
	public void deleteAppUser_Success() {
		
       given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        .when()
        .delete("/v1/app-user/d4e5f6a7-b8c9-7d6e-1f0a-4b5c6d7e8f9a")
            .then()
        .statusCode(204);				
		
	}	
}
