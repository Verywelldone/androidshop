package androidshop.controllers;


import androidshop.models.Product;
import androidshop.security.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save-product")
    public ResponseEntity<Product> saveProduct(@RequestBody final Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/get-products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "productId") int productId) {
        return productService.getProduct(productId);
    }

}
