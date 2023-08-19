package com.comp9412g3.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.comp9412g3.demo.model.Product;
import com.comp9412g3.demo.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductByName(product.getProductName());
        if (productOptional.isPresent()) {
            throw new IllegalStateException("Product Name taken");
        }
        productRepository.save(product);
        // System.out.println(product.getProductName());
    }

    public void deleteProduct(Long productId) {
        boolean exist = productRepository.existsById(productId);
        if (!exist) {
            throw new IllegalStateException("Product with Id " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, String productName, String description, Double price) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("product with id" + productId + " does not exist"));
        if (productName != null && productName.length() > 0 && !Objects.equals(product.getProductName(), productName)) {
            product.setProductName(productName);
        }
        if (description != null && description.length() > 0 && !Objects.equals(product.getDescription(), description)) {
            product.setDescription(description);
        }
        if (price != null && price.equals(product.getPrice())) {
            product.setPrice(price);
        }
    }
}
