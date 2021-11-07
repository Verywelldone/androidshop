package androidshop.security.services;

import androidshop.models.Product;
import androidshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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

    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(new ArrayList<>(productRepository.findAll()));
    }
}
