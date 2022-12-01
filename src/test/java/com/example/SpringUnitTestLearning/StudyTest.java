package com.example.SpringUnitTestLearning;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
    //Java reflection used, so we don't need private accessor here
    @Test
    void create(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }
    @Test
    //Disable test annotation
    @Disabled
    void create1(){
        System.out.println("create1");
    }
    //execute once before all test
    //need static
    @BeforeAll
    static void beforeAll(){
        System.out.println("before all");
    }

    //After all test execute once
    //Must static method
    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

    //Execute before every tests
    @BeforeEach
    void beforeEach(){
        System.out.println("before each");
    }

    //Execute after each test
    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }
}