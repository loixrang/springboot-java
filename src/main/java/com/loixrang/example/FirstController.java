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
    public String post(@RequestBody Order order) {
        return "Order Accepted and message is: " + order.toString();
    }

    @PostMapping("/record")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRecord(@RequestBody OrderRecord order) {
        return "Order Accepted and message is: " + order.toString();
    }

    @GetMapping("/hello/{user-name}")
    public String pathVariable(
           @PathVariable("user-name") String userName
    ) {
        return "my value = " + userName;
    }

    @GetMapping("/hello")
    public String paramName(
            @RequestParam("user-name") String userName,
            @RequestParam("last-name") String lastName
    ) {
        return "my value = " + userName + " " + lastName;
    }
}
