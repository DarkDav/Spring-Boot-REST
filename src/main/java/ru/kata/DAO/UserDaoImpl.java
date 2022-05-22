package ru.kata.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository

public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> findAllRole() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        Query q = entityManager.createQuery("delete from User User where id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> q = (entityManager.createQuery("select u from User u " +
                "join fetch u.roles where u.username = :username", User.class));
        q.setParameter("username", username);
        return q.getResultList().stream().findFirst().orElse(null);
    }
}