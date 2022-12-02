package com.example.SpringUnitTestLearning;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention
 * Hold annotation information till RUNTIME
 * @Target
 * What is target of this annotation, here target has set as Method, so this annotation will be method-level annotation
 *
 * @Tag & @Test Jupiter meta-annotations, a real part of this annotation.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@Tag("fast")
public @interface SlowTest {
}
