package ru.kata.DAO;




import ru.kata.model.User;

import java.util.List;

public interface UserDAO {

    List<User> findAllRole();

    User getById(long id);

    void save(User user);

    void delete(long id);

    void update(User user);

    User findByUsername(String username);
}