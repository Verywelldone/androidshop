package androidshop.service;

import androidshop.models.product.Category;
import androidshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<Category> saveCategory(Category category) {
        categoryRepository.save(category);
        return ResponseEntity.ok(category);
    }


    public ResponseEntity<Category> getCategory(int categoryId) {
        return ResponseEntity.ok(categoryRepository.getById(categoryId));
    }
}
