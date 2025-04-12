package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping
    public Flux<User> getUsers() {
        return service.findAll();
    }
}