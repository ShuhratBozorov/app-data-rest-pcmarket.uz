package uz.pdp.appdatarestpcmarketuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appdatarestpcmarketuz.entity.ProductInfo;
import uz.pdp.appdatarestpcmarketuz.projection.CustomProduct;
import uz.pdp.appdatarestpcmarketuz.projection.CustomProductInfo;

@RepositoryRestResource(path = "productInfo",excerptProjection = CustomProductInfo.class)
public interface ProductInfoRepository extends JpaRepository<ProductInfo,Integer> {
}
