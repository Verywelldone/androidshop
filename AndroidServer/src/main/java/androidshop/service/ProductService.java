package androidshop.service;

import androidshop.security.jwt.payload.response.MessageResponse;
import androidshop.models.product.Category;
import androidshop.models.product.Product;
import androidshop.repository.CategoryRepository;
import androidshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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

    public ResponseEntity<?> getProductsByCategory(int categoryId) {
        log.info("Category ID: {}", categoryId);

        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("No category found!"));

        return ResponseEntity.ok(new ArrayList<>(productRepository.findProductsByCategory(category.get())));
    }
}
