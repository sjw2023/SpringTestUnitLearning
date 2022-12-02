package com.example.SpringUnitTestLearning;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//Replace underscores in method name with whitespace
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
    //Java reflection used, so we don't need private accessor here
    @Test
    @DisplayName("한글도 됨, 이모지도됨 ")
    void create_new_study() {
        //Can end the test even before 300ms if test fail
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Test
        //Disable test annotation
        //@Disabled
    void create_new_study_again() {
        System.out.println("create1");
    }

    //execute once before all test
    //need static
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    //After all test execute once
    //Must static method
    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    //Execute before every tests
    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    //Execute after each test
    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }
}