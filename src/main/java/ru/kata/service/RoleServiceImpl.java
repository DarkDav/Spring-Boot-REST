package ru.kata.service;

import ru.kata.DAO.RoleDAO;
import ru.kata.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> findAllRole() {
        return roleDAO.findAllRole();
    }

    @Override
    @PostConstruct
    public void addDefaultRole() {
        roleDAO.save(new Role("ROLE_USER"));
        roleDAO.save(new Role("ROLE_ADMIN"));
    }

    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
      return new HashSet<>(roleDAO.findByIdRoles(roles));
    }
}