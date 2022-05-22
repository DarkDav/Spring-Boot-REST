package ru.kata.service;

import ru.kata.model.Role;
import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> findAllRole();
    void addDefaultRole();
    Set<Role> findByIdRoles(List<Long>roles);
}
