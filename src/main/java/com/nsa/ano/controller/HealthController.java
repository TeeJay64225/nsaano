package com.nsa.ano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class HealthController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/api/db-check")
    public String checkDatabase() {
        try (Connection connection = dataSource.getConnection()) {
            return "Database connection is valid!";
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }
}
