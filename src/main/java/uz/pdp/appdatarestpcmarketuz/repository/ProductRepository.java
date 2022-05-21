package uz.pdp.appdatarestpcmarketuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appdatarestpcmarketuz.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
