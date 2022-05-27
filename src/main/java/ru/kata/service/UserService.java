package ru.kata.service;

import ru.kata.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User getById(long id);

    void save(User user);

    void deleteById(long id);

    User findByUsername(String username);

    void update(User user);

    User passwordCoder(User user);
}
