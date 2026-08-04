package com.quickstop.quickstop_essentials.controllers;

import com.quickstop.quickstop_essentials.model.User;
import com.quickstop.quickstop_essentials.service.UserService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (userService.emailExists(user.getEmail())) {
            bindingResult.rejectValue("email","duplicate","An account with this email already exists.");
        }

        userService.registerUser(user);

        return "redirect:/login?registered";
    }
}