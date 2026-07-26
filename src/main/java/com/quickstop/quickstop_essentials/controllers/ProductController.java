package com.quickstop.quickstop_essentials.controllers;

import com.quickstop.quickstop_essentials.model.Brand;
import com.quickstop.quickstop_essentials.model.Category;
import com.quickstop.quickstop_essentials.model.Product;
import com.quickstop.quickstop_essentials.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // home page
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // about page
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    // pickup Locations page
    @GetMapping("/locations")
    public String locations() {
        return "locations";
    }

    // add product form
    @GetMapping("/products/new")
    public String displayAddProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("brands", Brand.values());
        model.addAttribute("categories", Category.values());

        return "add-product";
    }

    // save Product
    @PostMapping("/products")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("brands", Brand.values());
            model.addAttribute("categories", Category.values());

            return "add-product";
        }

        Product savedProduct = productService.saveProduct(product);

        return "redirect:/products/" + savedProduct.getId();
    }

    // product List with search, filter, sorting, pagination
    @GetMapping("/products")
    public String displayProducts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "6") int size,
        @RequestParam(defaultValue = "name") String sort,
        @RequestParam(defaultValue = "ASC") String direction,
        @RequestParam(required = false) String search,
        @RequestParam(required = false) Brand brand,
        @RequestParam(required = false) Category category,
        Model model
    ) {
        
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));

        Page<Product> productPage;

        if (search != null && !search.trim().isEmpty()) {
            productPage = productService.searchByName(search.trim(), pageable);
        } else if (brand != null && category != null) {
            productPage = productService.getProductsByBrandAndCategory(brand, category, pageable);
        } else if (brand != null) {
            productPage = productService.getProductsByBrand(brand, pageable);
        } else if (category != null) {
            productPage = productService.getProductsByCategory(category, pageable);
        } else {
            productPage = productService.getProducts(pageable);
        }

        model.addAttribute("products",productPage.getContent());
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("totalElements", productPage.getTotalElements());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("hasPrevious", productPage.hasPrevious());
        model.addAttribute("hasNext", productPage.hasNext());

        model.addAttribute("search", search);
        model.addAttribute("brand", brand);
        model.addAttribute("category", category);
        model.addAttribute("sort", sort);
        model.addAttribute("direction", direction);
        model.addAttribute("brands", Brand.values());
        model.addAttribute("categories",Category.values());

        return "products";
    }

    // product details
    @GetMapping("/products/{id}")
    public String productDetails(@PathVariable Long id, Model model) {
        
        Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        return "product-details";
    }
    
}