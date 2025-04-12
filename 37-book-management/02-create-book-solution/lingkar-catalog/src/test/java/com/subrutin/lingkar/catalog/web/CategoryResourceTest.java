package com.subrutin.lingkar.catalog.web;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import com.subrutin.lingkar.catalog.web.dto.CategoryCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryUpdateRequestDTO;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
@TestTransaction
public class CategoryResourceTest {
   
    @Test
    void testCreateCategory_Success() {
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

    @Test
    void testCreateCategory_ValidationError(){
        CategoryCreateRequestDTO dto = new CategoryCreateRequestDTO(
            "", //empty code should trigger validation error
             "Sejarah",
            "Buku - buku terkait sejarah indonesia dan dunia");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/v1/categories")
        .then()
            .statusCode(400);    
    }

    @Test
    void testFindCategoryList() {
        //v1/categories
    given()
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
    .when()
        .get("/v1/categories")
    .then()
        .statusCode(200)
        .body("result", notNullValue())
        .body("result[0].code", notNullValue())
        .body("pages", notNullValue())
        .body("elements", notNullValue())
        .time(lessThan(1000L));


    }

    @Test
    void testFindCategoryListWithPagination(){
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .queryParam("pages", 0)
            .queryParam("limit", 2)
        .when()
            .get("/v1/categories")
        .then()
            .statusCode(200)
            .body("result", hasSize(2))
            .time(lessThan(1000L));
    }


    @Test
    void testFindCategoryListWithSearch(){
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .queryParam("categoryName", "nov")
        .when()
            .get("/v1/categories")
        .then()
            .statusCode(200)
            .body("result[0].name", equalTo("Novel"))
            .time(lessThan(1500L));
    }

    @Test
    void testFindCategoryListWithSorting(){
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .queryParam("sortBy", "name")
            .queryParam("direction", "desc")
        .when()
            .get("/v1/categories")
        .then()
            .statusCode(200)
            .body("result[0].name", equalTo("Thriller"))
            .time(lessThan(1000L));
    }

    //positive case
    @Test
    void testFindCategoryDetail_Success() {
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        .when()
            .get("/v1/categories/novel")
        .then()
            .statusCode(200)
            .body("code", equalTo("NOVEL"))
            .body("name", equalTo("Novel"))
            .time(lessThan(1000L));        
        
    }

    //negative case
    @Test
    void testFindCategoryDetail_NotFound(){
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        .when()
            .get("/v1/categories/not-existent-code")
        .then()
            .statusCode(404)
            .time(lessThan(1000L));         
    }

    @Test
    void testUpdateCategory_Success() {
        // first create a category
        CategoryCreateRequestDTO dto = new CategoryCreateRequestDTO(
            "scifi",
            "Fiksi Ilmiah",
            "Karya Fiksi yang mengeksplorasi konsep futuristik, sains, dan teknologi");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/v1/categories")
        .then()
            .statusCode(201);

        // then update it
        CategoryUpdateRequestDTO updateDTO = new CategoryUpdateRequestDTO(
            "Fiksi-Ilmiah", 
            "Karya Fiksi yang mengeksplorasi konsep futuristik, sains, dan teknologi");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(updateDTO)
        .when()
            .put("/v1/categories/scifi")
        .then()
            .statusCode(200)
            .time(lessThan(1000L));
        
    }

    //nagative scenario of update category
    @Test
    void testUpdateCategory_NotFound() {

        CategoryUpdateRequestDTO updateDTO = new CategoryUpdateRequestDTO(
            "Sejarah Edited", 
            "Buku - buku terkait sejarah indonesia dan dunia");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(updateDTO)
        .when()
            .put("/v1/categories/notfound")
        .then()
            .statusCode(404)
            .time(lessThan(1000L));
    }

    @Test
    void testDeleteCategory_Success() {
        given()
        .when()
            .delete("/v1/categories/science_popular")
        .then()
            .statusCode(204)
            .time(lessThan(1000L));   
            
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        .when()
            .get("/v1/categories/science_popular")
        .then()
            .statusCode(404)
            .time(lessThan(1000L));        
             
    }



}
