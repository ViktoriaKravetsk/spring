package com.javaspring.demo.controller;

import com.javaspring.demo.entity.UserEntity;
import com.javaspring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    // Реєстрація
    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestParam String email, @RequestParam String password) {
        UserEntity user = userService.registerUser(email, password);
        return ResponseEntity.ok(user);
    }

    // Вхід
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        Optional<UserEntity> user = userService.loginUser(email, password);
        if (user.isPresent()) {
            return ResponseEntity.ok("Успішний вхід!");
        } else {
            return ResponseEntity.status(401).body("Неправильний email або пароль.");
        }
    }

    // Вихід
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Успішний вихід!");
    }
}
