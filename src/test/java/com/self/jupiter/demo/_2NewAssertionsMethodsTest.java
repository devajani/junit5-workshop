package com.self.jupiter.demo;

import com.self.jupiter.bean.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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
    void assertEveryAttributeOfEmployee() {
        Employee employee = new Employee(100L, "test"); // lets say we get it from a service
        assertAll(
                () -> assertEquals("test", employee.getName()),
                () -> assertEquals(100L, employee.getId())
        );
    }


    @Test
    void timeout() {
        assertTimeout(Duration.ofMillis(100), () -> System.out.println("Hello here"));
    }

    @Test
        // runs in the same thread, executes the process and tells exceeds by how much
    void timeoutExceeded() {
        assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(200));
    }

    @Test
        // runs in a different thread, kills it if it takes more time
    void timeoutExceededWithPreemption() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(200));
    }

}
