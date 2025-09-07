package com.trainibit.labs.spring_boot_hibernate_crud.controller;

import com.trainibit.labs.spring_boot_hibernate_crud.dto.UserRequest;
import com.trainibit.labs.spring_boot_hibernate_crud.model.User;
import com.trainibit.labs.spring_boot_hibernate_crud.model.Profile;
import com.trainibit.labs.spring_boot_hibernate_crud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/v1")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());

        Profile profile = new Profile();
        profile.setBio(userRequest.getProfileBio());
        profile.setUser(user);
        user.setProfile(profile);

        userService.saveUserWithProfile(user);
        return "Usuario creado con éxito";

    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

}
