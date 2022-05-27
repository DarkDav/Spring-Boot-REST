package ru.kata.service;

import ru.kata.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> findAllRole();

    void save(Role role);

    Set<Role> findByIdRoles(List<Long> roles);
}
