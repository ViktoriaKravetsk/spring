package com.javaspring.demo.service;

import com.javaspring.demo.entity.UserEntity;
import com.javaspring.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Реєстрація користувача
    public UserEntity registerUser(String email, String password) {
        UserEntity newUser = new UserEntity();
        newUser.setEmail(email);
        newUser.setPassword(password);
        return userRepository.save(newUser);
    }

    // Вхід користувача
    public Optional<UserEntity> loginUser(String email, String password) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
}
