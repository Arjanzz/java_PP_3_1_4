package ru.nerobkov.spring.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nerobkov.spring.rest.models.User;
import ru.nerobkov.spring.rest.service.RoleService;
import ru.nerobkov.spring.rest.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public RESTController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        List<User> allUsers = userService.findAll();
        return allUsers;
    }

    @GetMapping("/users/current_user")
    public User showCurrentUser(Principal principal) {
        User currentUser = userService.findByUsername(principal.getName());
        return currentUser;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        return user;
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        user.setRoles(roleService.findByName(user.getStrRoles()));
        userService.saveUser(user);
        return user;
    }

    @PatchMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        user.setRoles(roleService.findByName(user.getStrRoles()));
        user.setId(id);
        userService.update(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
