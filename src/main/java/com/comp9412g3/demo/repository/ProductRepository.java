package com.comp9412g3.demo.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.comp9412g3.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    // @Query("SELECT p FROM Product p WHERE p.product_id")
    // Optional<Product> findProductByProductId(Long productId);
    @Query("select p from Product p where p.productName = ?1")
    Optional<Product> findProductByName(String productName);
}
