package uz.pdp.appdatarestpcmarketuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appdatarestpcmarketuz.entity.Customer;
import uz.pdp.appdatarestpcmarketuz.projection.CustomCustomer;

@RepositoryRestResource(path = "customer",excerptProjection = CustomCustomer.class)
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
