package com.example.SpringUnitTestLearning;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

//Replace underscores in method name with whitespace
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
    //Java reflection used, so we don't need private accessor here

    @FastTest
    @DisplayName("한글도 됨, 이모지도됨 ")
    void create_new_study() {
            Study actual = new Study(10);
            assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @SlowTest
    @DisplayName("Making study group Slow ")
    void create_new_study_again() {
        System.out.println("create1");
    }

    //Repeat test 10 times
    //RepetitionInfo repetition information object
    @DisplayName("Display name string")
    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetition}")
    void repeatTest(RepetitionInfo repetitionInfo){
        System.out.println("Test " + repetitionInfo.getCurrentRepetition() +"/"
        + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("Parameterized test")
    //Refer the first parameter in @ValueSource
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    //One pair per input
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterizedTest(ArgumentsAccessor argumentsAccessor){
        Study study = new Study( argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        System.out.println(study);
    }

    static class StudyConverter extends SimpleArgumentConverter{
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class,targetType,"Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
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