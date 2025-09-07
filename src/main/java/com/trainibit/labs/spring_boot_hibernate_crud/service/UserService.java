package com.trainibit.labs.spring_boot_hibernate_crud.service;

import com.trainibit.labs.spring_boot_hibernate_crud.model.User;

public interface UserService {
    void saveUserWithProfile(User user);
    User getUserById(int userId);

}