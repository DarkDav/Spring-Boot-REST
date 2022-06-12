package ru.kata.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.DAO.RoleDAO;
import ru.kata.model.Role;
import ru.kata.model.User;
import ru.kata.service.RoleService;
import ru.kata.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitDefUsers {
    private UserService userService;
    private RoleService roleService;
    private RoleDAO roleDAO;

    @Autowired
    public InitDefUsers(UserService userService, RoleService roleService, RoleDAO roleDAO) {
        this.userService = userService;
        this.roleService = roleService;
        this.roleDAO = roleDAO;
    }

    @PostConstruct
    public void post() {
        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));
        Set<Role> roles1 = new HashSet<>();
        roles1.add(roleDAO.findById(1L));
        Set<Role> roles2 = new HashSet<>();
        roles2.add(roleDAO.findById(1L));
        roles2.add(roleDAO.findById(2L));
        User user1 = new User("Harry", "Osborn", (byte) 25, "lolo@mail.com", "user", "12345", roles1);
        User user2 = new User("Rayn", "Gosling", (byte) 30, "admin@mail.com", "admin", "admin", roles2);
        userService.save(user1);
        userService.save(user2);
    }


}
