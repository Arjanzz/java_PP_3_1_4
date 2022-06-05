package ru.nerobkov.spring.rest.service;

import ru.nerobkov.spring.rest.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User findByUsername(String username);
    void saveUser(User user);
    void deleteById(Long id);
    void update(User user);
}
