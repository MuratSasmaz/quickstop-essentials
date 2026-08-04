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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/locations")
    public String locations() {
        return "locations";
    }

    @GetMapping("/products/new")
    public String displayAddProduct(Model model) {

        model.addAttribute("product", new Product());
        model.addAttribute("brands", Brand.values());
        model.addAttribute("categories", Category.values());

        return "products/form";
    }

    @PostMapping("/products")
    public String saveProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult bindingResult,
            Model model
    ) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("brands", Brand.values());
            model.addAttribute("categories", Category.values());

            return "products/form";
        }

        Product savedProduct = productService.saveProduct(product);

        return "redirect:/products/" + savedProduct.getId();
    }

    @GetMapping("/products")
    public String displayProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestParam(defaultValue = "nameAsc") String sort,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String category,
            Model model
    ) {

        if (page < 0) {
            page = 0;
        }

        if (size <= 0) {
            size = 6;
        }

        Sort productSort = getProductSort(sort);
        Pageable pageable = PageRequest.of(page, size, productSort);

        Brand selectedBrand = parseBrand(brand);
        Category selectedCategory = parseCategory(category);

        Page<Product> productPage;

        if (search != null && !search.trim().isEmpty()) {

            productPage = productService.searchByName(
                    search.trim(),
                    pageable
            );

        } else if (
                selectedBrand != null &&
                        selectedCategory != null
        ) {

            productPage =
                    productService.getProductsByBrandAndCategory(
                            selectedBrand,
                            selectedCategory,
                            pageable
                    );

        } else if (selectedBrand != null) {

            productPage = productService.getProductsByBrand(
                    selectedBrand,
                    pageable
            );

        } else if (selectedCategory != null) {

            productPage = productService.getProductsByCategory(
                    selectedCategory,
                    pageable
            );

        } else {

            productPage = productService.getProducts(pageable);
        }

        model.addAttribute("productPage", productPage);
        model.addAttribute("brands", Brand.values());
        model.addAttribute("categories", Category.values());

        model.addAttribute("search", search);
        model.addAttribute("brand", brand);
        model.addAttribute("category", category);
        model.addAttribute("sort", sort);

        return "products/list";
    }

    @GetMapping("/products/{id}")
    public String productDetails(
            @PathVariable Long id,
            Model model
    ) {

        Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        return "products/details";
    }

    @GetMapping("/products/{id}/edit")
    public String displayEditProduct(
            @PathVariable Long id,
            Model model
    ) {

        Product product = productService.getProductById(id);

        model.addAttribute("product", product);
        model.addAttribute("brands", Brand.values());
        model.addAttribute("categories", Category.values());

        return "products/edit";
    }

    @PostMapping("/products/{id}/edit")
    public String updateProduct(
            @PathVariable Long id,
            @Valid @ModelAttribute("product") Product product,
            BindingResult bindingResult,
            Model model
    ) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("brands", Brand.values());
            model.addAttribute("categories", Category.values());

            return "products/edit";
        }

        Product updatedProduct =
                productService.updateProduct(id, product);

        return "redirect:/products/" + updatedProduct.getId();
    }

    @PostMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return "redirect:/products";
    }

    private Sort getProductSort(String sort) {

        return switch (sort) {

            case "nameDesc" ->
                    Sort.by(Sort.Direction.DESC, "name");

            case "priceAsc" ->
                    Sort.by(Sort.Direction.ASC, "price");

            case "priceDesc" ->
                    Sort.by(Sort.Direction.DESC, "price");

            default ->
                    Sort.by(Sort.Direction.ASC, "name");
        };
    }

    private Brand parseBrand(String brand) {

        if (brand == null || brand.isBlank()) {
            return null;
        }

        try {
            return Brand.valueOf(brand);
        } catch (IllegalArgumentException exception) {
            return null;
        }
    }

    private Category parseCategory(String category) {

        if (category == null || category.isBlank()) {
            return null;
        }

        try {
            return Category.valueOf(category);
        } catch (IllegalArgumentException exception) {
            return null;
        }
    }
}