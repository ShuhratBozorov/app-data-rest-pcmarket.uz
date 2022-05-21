package uz.pdp.appdatarestpcmarketuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appdatarestpcmarketuz.entity.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,Integer> {
}
