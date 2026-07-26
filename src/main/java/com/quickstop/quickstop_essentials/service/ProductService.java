package com.quickstop.quickstop_essentials.service;

import com.quickstop.quickstop_essentials.model.Brand;
import com.quickstop.quickstop_essentials.model.Category;
import com.quickstop.quickstop_essentials.model.Product;
import com.quickstop.quickstop_essentials.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // pagination
    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    // search
    public Page<Product> searchByName(String name, Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    // filters
    public Page<Product> getProductsByBrand(Brand brand, Pageable pageable) {
        return productRepository.findByBrand(brand, pageable);
    }

    public Page<Product> getProductsByCategory(Category category, Pageable pageable) {
        return productRepository.findByCategory(category, pageable);
    }


    public Page<Product> getProductsByBrandAndCategory(Brand brand, Category category, Pageable pageable) {
        return productRepository.findByBrandAndCategory(brand, category, pageable);
    }
}