package com.self.jupiter.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class _2NewAssertionsMethodsTest {

    //Demo assertAll
    @Test
    void standardAssertions() {
        assertEquals(2, 2);
        assertEquals(4, 2 + 2, "error message");
        assertEquals(1, 1, () -> "error message lazily loaded");
    }

    //Demo lazy loading of error message
    @Test
    void testErrorMessage() {
        assertEquals("this is a string",  // expected
                getActualString(), // test method
                getErrorMessage());  // error message method called even if no error
    }

    private String getActualString() {
        System.out.println("Inside the getCompleteString method");
        return "this is a string";
    }

    private String getErrorMessage() {
        System.out.println("Inside getErrorMessage");
        return "This should never happen";
    }


    @Test
    void timeoutOkay() {
        assertTimeout(Duration.ofMillis(100), () -> System.out.println("Hello"));
    }

    @Test
    @Disabled("Disable until demo")
    void timeoutExceeded() {
        assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(200));
    }

    @Test
    @Disabled("Disable until demo")
    void timeoutExceededWithPreemption() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(200));
    }

}
