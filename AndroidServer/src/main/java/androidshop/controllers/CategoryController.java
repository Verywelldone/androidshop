package androidshop.controllers;

import androidshop.models.product.Category;
import androidshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save-category")
    public ResponseEntity<Category> saveCategory(@RequestBody final Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("category/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable(value = "categoryId") int categoryId) {
        return categoryService.getCategory(categoryId);
    }

}
