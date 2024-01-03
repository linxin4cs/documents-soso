package com.zlx.documentssosobackend.controller;

import com.zlx.documentssosobackend.entity.User;
import com.zlx.documentssosobackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    private AuthService authService;

    @PostMapping("/users/login")
    public int login(@RequestBody User user) {
        return authService.login(user);
    }

    @PostMapping("/users/register")
    public String register(@RequestBody User user) {
        System.out.println(user);
        return authService.register(user.password);
    }
}
