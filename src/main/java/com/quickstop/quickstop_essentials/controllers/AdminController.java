package com.quickstop.quickstop_essentials.controllers;

import com.quickstop.quickstop_essentials.model.Role;
import com.quickstop.quickstop_essentials.repository.UserRepository;
import com.quickstop.quickstop_essentials.service.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final ProductService productService;

    public AdminController(
            UserRepository userRepository,
            ProductService productService
    ) {
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @GetMapping({"", "/", "/dashboard"})
    public String showAdminDashboard(Model model) {

        model.addAttribute(
                "users",
                userRepository.findAllByOrderByCreatedAtDesc()
        );

        model.addAttribute(
                "userCount",
                userRepository.count()
        );

        model.addAttribute(
                "staffCount",
                userRepository.countByRole(Role.STAFF)
        );

        model.addAttribute(
                "customerCount",
                userRepository.countByRole(Role.CUSTOMER)
        );

        model.addAttribute(
                "productCount",
                productService.countProducts()
        );

        return "admin/dashboard";
    }
}