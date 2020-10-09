package com.self.jupiter.demo;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class _1TestInstanceAndOrderTest {
    private String test;

    @Test
    @Order(1)
    void testInstance() {
        test = "TEST";
    }

    @Test
    @Order(2)
    void testInitialise1() {
        System.out.println(test);
    }

    @Test
    @Order(3)
    void testInitialise2() {
        System.out.println(test);
    }
}
