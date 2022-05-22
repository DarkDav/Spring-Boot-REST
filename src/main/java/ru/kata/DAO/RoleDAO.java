package ru.kata.DAO;


import ru.kata.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDAO {
    List<Role> findAllRole();

    void save(Role role);

    Role findById(long id);

    Set<Role> findByIdRoles(List<Long> roles);

    Role getRole(String userRole);
}