package com.androidserver.service;

import com.androidserver.model.Product;
import com.androidserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Product> saveProduct(Product product) {
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<Product> getProduct(int productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty())
            return null;
        return ResponseEntity.ok(product.get());
    }
}
