package uz.pdp.appdatarestpcmarketuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appdatarestpcmarketuz.entity.User;
import uz.pdp.appdatarestpcmarketuz.projection.CustomUser;

@RepositoryRestResource(path = "user",excerptProjection = CustomUser.class)
public interface UserRepository extends JpaRepository<User,Integer> {
}
