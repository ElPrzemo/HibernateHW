package org.example.controller;

import org.example.model.UserDetails;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getList(Model model) {
        List<UserDetails> users = userService.getAllUsers();

        model.addAttribute("userList", users);

        return "userList";
    }


}
