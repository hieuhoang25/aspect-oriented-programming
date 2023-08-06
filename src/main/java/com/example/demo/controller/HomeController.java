package com.example.demo.controller;

import com.example.demo.model.Database;
import com.example.demo.service.DatabaseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@Slf4j
public class HomeController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("/db")
    public ResponseEntity<?> connect(@RequestBody Database database) throws SQLException{
        return ResponseEntity.ok(databaseService.connect(database));
    }

}
