package com.subrutin.lingkar.catalog.web;

import org.junit.jupiter.api.Test;

import com.subrutin.lingkar.catalog.web.dto.LoginRequestDTO;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class AuthResourceTest {
	@Test
	public void testLogin(){
		LoginRequestDTO loginRequest = new LoginRequestDTO(
			"user01", "password"
		);
		given()
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON)
	    .body(loginRequest)
        .when()
        .post("/v1/auth/login")
        	.then()
        .statusCode(200)
        .body("username",equalTo("user01"));
		
	}
}
