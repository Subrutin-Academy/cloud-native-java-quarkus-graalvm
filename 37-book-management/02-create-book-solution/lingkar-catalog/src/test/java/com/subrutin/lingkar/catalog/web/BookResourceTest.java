package com.subrutin.lingkar.catalog.web;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.subrutin.lingkar.catalog.web.dto.BookCreateRequestDTO;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class BookResourceTest {

    @Test
    void createBook_Success(){
        //create payload book 
        BookCreateRequestDTO requestDTO = new BookCreateRequestDTO(
            "Einstein: His Life and Universe",
            "Einstein: His Life and Universe adalah biografi komprehensif tentang Albert Einstein yang ditulis oleh Walter Isaacson. Buku ini mengeksplorasi tidak hanya pencapaian ilmiah Einstein yang revolusioner, tetapi juga kehidupan pribadinya yang kompleks, pandangan politiknya, dan kepribadiannya yang unik. Isaacson menggambarkan perjalanan Einstein dari masa kecilnya yang pemberontak hingga menjadi ikon ilmiah dunia. Buku ini menjelaskan bagaimana kreativitas dan imajinasinya yang luar biasa memungkinkannya mengembangkan teori relativitas dan kontribusi penting lainnya pada fisika modern. Isaacson juga mengeksplorasi hubungan Einstein dengan istri-istrinya, anak-anaknya, dan koleganya, serta keterlibatannya dalam isu-isu sosial dan politik seperti pacifisme, Zionisme, dan perlucutan senjata nuklir. Berdasarkan arsip pribadi Einstein yang baru dibuka dan penelitian ekstensif, biografi ini memberikan potret mendalam tentang salah satu pikiran paling brilian dan berpengaruh dalam sejarah manusia",
            704,
            2007,
            16L,
            List.of(16L),
            List.of("biography")
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(requestDTO)
        .when()
            .post("/v1/books")
        .then()
            .statusCode(200);
    }

    //negative case invalid author
    @Test
    void createBook_InvalidAuthor() {
        //create payload book 
        BookCreateRequestDTO requestDTO = new BookCreateRequestDTO(
            "Einstein: His Life and Universe",
            "Einstein: His Life and Universe adalah biografi komprehensif tentang Albert Einstein yang ditulis oleh Walter Isaacson. Buku ini mengeksplorasi tidak hanya pencapaian ilmiah Einstein yang revolusioner, tetapi juga kehidupan pribadinya yang kompleks, pandangan politiknya, dan kepribadiannya yang unik. Isaacson menggambarkan perjalanan Einstein dari masa kecilnya yang pemberontak hingga menjadi ikon ilmiah dunia. Buku ini menjelaskan bagaimana kreativitas dan imajinasinya yang luar biasa memungkinkannya mengembangkan teori relativitas dan kontribusi penting lainnya pada fisika modern. Isaacson juga mengeksplorasi hubungan Einstein dengan istri-istrinya, anak-anaknya, dan koleganya, serta keterlibatannya dalam isu-isu sosial dan politik seperti pacifisme, Zionisme, dan perlucutan senjata nuklir. Berdasarkan arsip pribadi Einstein yang baru dibuka dan penelitian ekstensif, biografi ini memberikan potret mendalam tentang salah satu pikiran paling brilian dan berpengaruh dalam sejarah manusia",
            704,
            2007,
            16L,
            List.of(9999L),//author not found
            List.of("biography")
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(requestDTO)
        .when()
            .post("/v1/books")
        .then()
            .statusCode(404);
    }

    //negative case invalid category
    @Test
    void createBook_InvalidCategory() {
        //create payload book 
        BookCreateRequestDTO requestDTO = new BookCreateRequestDTO(
            "Einstein: His Life and Universe",
            "Einstein: His Life and Universe adalah biografi komprehensif tentang Albert Einstein yang ditulis oleh Walter Isaacson. Buku ini mengeksplorasi tidak hanya pencapaian ilmiah Einstein yang revolusioner, tetapi juga kehidupan pribadinya yang kompleks, pandangan politiknya, dan kepribadiannya yang unik. Isaacson menggambarkan perjalanan Einstein dari masa kecilnya yang pemberontak hingga menjadi ikon ilmiah dunia. Buku ini menjelaskan bagaimana kreativitas dan imajinasinya yang luar biasa memungkinkannya mengembangkan teori relativitas dan kontribusi penting lainnya pada fisika modern. Isaacson juga mengeksplorasi hubungan Einstein dengan istri-istrinya, anak-anaknya, dan koleganya, serta keterlibatannya dalam isu-isu sosial dan politik seperti pacifisme, Zionisme, dan perlucutan senjata nuklir. Berdasarkan arsip pribadi Einstein yang baru dibuka dan penelitian ekstensif, biografi ini memberikan potret mendalam tentang salah satu pikiran paling brilian dan berpengaruh dalam sejarah manusia",
            704,
            2007,
            16L,
            List.of(9999L),
            List.of("not-found-category")//category not found
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(requestDTO)
        .when()
            .post("/v1/books")
        .then()
            .statusCode(404);
    }

    //negative case invalid publisher
    @Test
    void createBook_InvalidPublisher() {
        //create payload book 
        BookCreateRequestDTO requestDTO = new BookCreateRequestDTO(
            "Einstein: His Life and Universe",
            "Einstein: His Life and Universe adalah biografi komprehensif tentang Albert Einstein yang ditulis oleh Walter Isaacson. Buku ini mengeksplorasi tidak hanya pencapaian ilmiah Einstein yang revolusioner, tetapi juga kehidupan pribadinya yang kompleks, pandangan politiknya, dan kepribadiannya yang unik. Isaacson menggambarkan perjalanan Einstein dari masa kecilnya yang pemberontak hingga menjadi ikon ilmiah dunia. Buku ini menjelaskan bagaimana kreativitas dan imajinasinya yang luar biasa memungkinkannya mengembangkan teori relativitas dan kontribusi penting lainnya pada fisika modern. Isaacson juga mengeksplorasi hubungan Einstein dengan istri-istrinya, anak-anaknya, dan koleganya, serta keterlibatannya dalam isu-isu sosial dan politik seperti pacifisme, Zionisme, dan perlucutan senjata nuklir. Berdasarkan arsip pribadi Einstein yang baru dibuka dan penelitian ekstensif, biografi ini memberikan potret mendalam tentang salah satu pikiran paling brilian dan berpengaruh dalam sejarah manusia",
            704,
            2007,
            9999L,
            List.of(16L),
            List.of("biography")
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(requestDTO)
        .when()
            .post("/v1/books")
        .then()
            .statusCode(404);
    }


    // negative case blank title
    @Test
    void createBook_BlankTitle() {
        // create payload book
        BookCreateRequestDTO requestDTO = new BookCreateRequestDTO(
                "", // blank title
                "Einstein: His Life and Universe adalah biografi komprehensif tentang Albert Einstein yang ditulis oleh Walter Isaacson. Buku ini mengeksplorasi tidak hanya pencapaian ilmiah Einstein yang revolusioner, tetapi juga kehidupan pribadinya yang kompleks, pandangan politiknya, dan kepribadiannya yang unik. Isaacson menggambarkan perjalanan Einstein dari masa kecilnya yang pemberontak hingga menjadi ikon ilmiah dunia. Buku ini menjelaskan bagaimana kreativitas dan imajinasinya yang luar biasa memungkinkannya mengembangkan teori relativitas dan kontribusi penting lainnya pada fisika modern. Isaacson juga mengeksplorasi hubungan Einstein dengan istri-istrinya, anak-anaknya, dan koleganya, serta keterlibatannya dalam isu-isu sosial dan politik seperti pacifisme, Zionisme, dan perlucutan senjata nuklir. Berdasarkan arsip pribadi Einstein yang baru dibuka dan penelitian ekstensif, biografi ini memberikan potret mendalam tentang salah satu pikiran paling brilian dan berpengaruh dalam sejarah manusia",
                704,
                2007,
                9999L,
                List.of(16L),
                List.of("biography"));

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(requestDTO)
        .when()
            .post("/v1/books")
        .then()
            .statusCode(400);
    }

    // negative case blank publisher
    @Test
    void createBook_BlankPublisher() {
        // create payload book
        BookCreateRequestDTO requestDTO = new BookCreateRequestDTO(
                "Einstein: His Life and Universe",
                "Einstein: His Life and Universe adalah biografi komprehensif tentang Albert Einstein yang ditulis oleh Walter Isaacson. Buku ini mengeksplorasi tidak hanya pencapaian ilmiah Einstein yang revolusioner, tetapi juga kehidupan pribadinya yang kompleks, pandangan politiknya, dan kepribadiannya yang unik. Isaacson menggambarkan perjalanan Einstein dari masa kecilnya yang pemberontak hingga menjadi ikon ilmiah dunia. Buku ini menjelaskan bagaimana kreativitas dan imajinasinya yang luar biasa memungkinkannya mengembangkan teori relativitas dan kontribusi penting lainnya pada fisika modern. Isaacson juga mengeksplorasi hubungan Einstein dengan istri-istrinya, anak-anaknya, dan koleganya, serta keterlibatannya dalam isu-isu sosial dan politik seperti pacifisme, Zionisme, dan perlucutan senjata nuklir. Berdasarkan arsip pribadi Einstein yang baru dibuka dan penelitian ekstensif, biografi ini memberikan potret mendalam tentang salah satu pikiran paling brilian dan berpengaruh dalam sejarah manusia",
                704,
                2007,
                null,
                List.of(16L),
                List.of("biography"));

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(requestDTO)
        .when()
            .post("/v1/books")
        .then()
            .statusCode(400);
    } 

    //negative case blank authors
    @Test
    void createBook_BlankAuthors() {
        //create payload book
        BookCreateRequestDTO requestDTO = new BookCreateRequestDTO(
            "Einstein: His Life and Universe", 
            "Einstein: His Life and Universe adalah biografi komprehensif tentang Albert Einstein yang ditulis oleh Walter Isaacson. Buku ini mengeksplorasi tidak hanya pencapaian ilmiah Einstein yang revolusioner, tetapi juga kehidupan pribadinya yang kompleks, pandangan politiknya, dan kepribadiannya yang unik. Isaacson menggambarkan perjalanan Einstein dari masa kecilnya yang pemberontak hingga menjadi ikon ilmiah dunia. Buku ini menjelaskan bagaimana kreativitas dan imajinasinya yang luar biasa memungkinkannya mengembangkan teori relativitas dan kontribusi penting lainnya pada fisika modern. Isaacson juga mengeksplorasi hubungan Einstein dengan istri-istrinya, anak-anaknya, dan koleganya, serta keterlibatannya dalam isu-isu sosial dan politik seperti pacifisme, Zionisme, dan perlucutan senjata nuklir. Berdasarkan arsip pribadi Einstein yang baru dibuka dan penelitian ekstensif, biografi ini memberikan potret mendalam tentang salah satu pikiran paling brilian dan berpengaruh dalam sejarah manusia",
            704,
            2007,
            16L,
            List.of(),
            List.of("biography")
        );
    
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(requestDTO)
        .when()
            .post("/v1/books")
        .then()
            .statusCode(400);
    }

    //negative case blank category
    @Test
    void createBook_BlankCategory() {
        //create payload book
        BookCreateRequestDTO requestDTO = new BookCreateRequestDTO(
            "Einstein: His Life and Universe", 
            "Einstein: His Life and Universe adalah biografi komprehensif tentang Albert Einstein yang ditulis oleh Walter Isaacson. Buku ini mengeksplorasi tidak hanya pencapaian ilmiah Einstein yang revolusioner, tetapi juga kehidupan pribadinya yang kompleks, pandangan politiknya, dan kepribadiannya yang unik. Isaacson menggambarkan perjalanan Einstein dari masa kecilnya yang pemberontak hingga menjadi ikon ilmiah dunia. Buku ini menjelaskan bagaimana kreativitas dan imajinasinya yang luar biasa memungkinkannya mengembangkan teori relativitas dan kontribusi penting lainnya pada fisika modern. Isaacson juga mengeksplorasi hubungan Einstein dengan istri-istrinya, anak-anaknya, dan koleganya, serta keterlibatannya dalam isu-isu sosial dan politik seperti pacifisme, Zionisme, dan perlucutan senjata nuklir. Berdasarkan arsip pribadi Einstein yang baru dibuka dan penelitian ekstensif, biografi ini memberikan potret mendalam tentang salah satu pikiran paling brilian dan berpengaruh dalam sejarah manusia",
            704,
            2007,
            16L,
            List.of(16L),
            List.of()
        );
    
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(requestDTO)
        .when()
            .post("/v1/books")
        .then()
            .statusCode(400);
    }

}
