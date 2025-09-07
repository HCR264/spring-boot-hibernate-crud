package com.trainibit.labs.spring_boot_hibernate_crud.service.impl;



import com.trainibit.labs.spring_boot_hibernate_crud.model.User;
import com.trainibit.labs.spring_boot_hibernate_crud.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveUserWithProfile(User user) {
        entityManager.persist(user); // cascade saves profile too
    }

    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }
}