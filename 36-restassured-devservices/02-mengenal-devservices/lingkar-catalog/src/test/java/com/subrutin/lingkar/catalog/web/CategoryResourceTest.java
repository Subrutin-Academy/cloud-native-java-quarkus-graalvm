package com.subrutin.lingkar.catalog.web;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import com.subrutin.lingkar.catalog.web.dto.CategoryCreateRequestDTO;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
@TestTransaction
public class CategoryResourceTest {
   
    @Test
    void testCreateCategory() {
        CategoryCreateRequestDTO dto = new CategoryCreateRequestDTO(
            "history",
             "Sejarah",
            "Buku - buku terkait sejarah indonesia dan dunia");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/v1/categories")
        .then()
            .statusCode(201);
    }
}
