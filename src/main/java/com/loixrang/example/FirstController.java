package com.loixrang.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String sayHello() {
        return "Hello from my first controller";
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody String message) {
        return "Order Accepted and message is: " + message;
    }
}
