package com.quickstop.quickstop_essentials.repository;

import com.quickstop.quickstop_essentials.model.Brand;
import com.quickstop.quickstop_essentials.model.Category;
import com.quickstop.quickstop_essentials.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContainingIgnoreCase(
            String name,
            Pageable pageable
    );

    Page<Product> findByBrand(
            Brand brand,
            Pageable pageable
    );

    Page<Product> findByCategory(
            Category category,
            Pageable pageable
    );

    Page<Product> findByBrandAndCategory(
            Brand brand,
            Category category,
            Pageable pageable
    );
}