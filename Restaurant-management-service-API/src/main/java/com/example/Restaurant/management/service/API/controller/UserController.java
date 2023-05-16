package com.example.Restaurant.management.service.API.controller;

import com.example.Restaurant.management.service.API.dto.SignInInput;
import com.example.Restaurant.management.service.API.dto.SignInOutput;
import com.example.Restaurant.management.service.API.dto.SignUpInput;
import com.example.Restaurant.management.service.API.dto.SignUpOutput;
import com.example.Restaurant.management.service.API.model.User;
import com.example.Restaurant.management.service.API.service.TokenService;
import com.example.Restaurant.management.service.API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService UserService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/signup")
    public SignUpOutput createUser(@RequestBody SignUpInput signUpInput)
    {
        return UserService.signup(signUpInput);
    }

    @PostMapping("/signIn")
    public SignInOutput createUser(@RequestBody SignInInput signInInput)
    {
        return UserService.signIn(signInInput);
    }


    @GetMapping("/getAll")
    public List<User> getAllUsers()
    {
        return UserService.getAllUser();
    }



    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User restaurant)
    {
        return UserService.updateUser(id, restaurant);
    }

}
