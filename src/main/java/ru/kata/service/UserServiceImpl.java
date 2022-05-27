package ru.kata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import ru.kata.DAO.RoleDAO;
import ru.kata.DAO.UserDAO;
import ru.kata.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;

        this.passwordEncoder = passwordEncoder;


    }

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAllRole();
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(passwordCoder(user));
    }

    @Transactional
    @Override
    public void update(User user) {

        if (user.getPassword() == null) {
            user.setPassword(getById(user.getUserId()).getPassword());
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userDAO.update(user);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        userDAO.delete(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

}

