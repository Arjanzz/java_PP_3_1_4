package ru.nerobkov.spring.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nerobkov.spring.rest.models.User;
import ru.nerobkov.spring.rest.service.RoleService;
import ru.nerobkov.spring.rest.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminsController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminsController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String index(Principal principal, Model model) {
        User currentUser = userService.findByUsername(principal.getName());
        model.addAttribute("current_user", currentUser);
        model.addAttribute("rolesList", roleService.findAll());
        return "admin";
    }
}
