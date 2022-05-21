package uz.pdp.appdatarestpcmarketuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appdatarestpcmarketuz.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);
}
