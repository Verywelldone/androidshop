package androidshop.repository;

import androidshop.models.product.Category;
import androidshop.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductsByCategory(Category category);
}
