package com.subrutin.quarkus.learnjunit.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BookShelfTest {
    //Arrange

    @BeforeAll
    public static void setup(){
        System.out.println("setup");
    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    //Act
    @Test
    void testAdd() {
        //Assert
        System.out.println("Add");

    }

    @Test
    void testFindBookList() {
        System.out.println("testfindBookList");

    }

    @AfterEach
    public void afterTest(){
        System.out.println("afterTest");
    }


    @AfterAll
    public static void tearsDown(){
        System.out.println("tearsDown");
    }
}
