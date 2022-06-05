package ru.nerobkov.spring.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nerobkov.spring.rest.models.User;
import ru.nerobkov.spring.rest.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String show(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("current_user", user);
        return "user";
    }

}
