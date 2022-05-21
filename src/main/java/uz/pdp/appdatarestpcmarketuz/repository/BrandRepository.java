package uz.pdp.appdatarestpcmarketuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appdatarestpcmarketuz.entity.Brand;
import uz.pdp.appdatarestpcmarketuz.projection.CustomBrand;

@RepositoryRestResource(path = "brand",excerptProjection = CustomBrand.class)
public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
