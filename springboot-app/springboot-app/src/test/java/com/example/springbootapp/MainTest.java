package com.example.springbootapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void mainMethodRunsSuccessfully() {
        // Simulate the main method execution
        String[] args = {};
        Main.main(args);

        // If the main method executes without throwing an exception,
        // it indicates that the Spring Boot application started successfully.
        // We can't really test the inner workings of the SpringApplication.run() method
        // in a unit test, so this is more of a sanity check to ensure that the
        // application can at least start up without crashing.
        assertTrue(true, "Application started successfully.");
    }
}

