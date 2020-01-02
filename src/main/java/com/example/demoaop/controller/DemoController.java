package com.example.demoaop.controller;


import com.example.demoaop.security.BasicAuthentication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/home")
    @BasicAuthentication
    public ResponseEntity<?> getHome(@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken) {
        return new ResponseEntity<>("Hello", HttpStatus.OK);

    }

}
