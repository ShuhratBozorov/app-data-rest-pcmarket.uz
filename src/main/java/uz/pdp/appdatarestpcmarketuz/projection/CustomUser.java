package uz.pdp.appdatarestpcmarketuz.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarestpcmarketuz.entity.User;

@Projection(types = User.class)
public interface CustomUser {
    Integer getId();

    String getEmail();

    String getPassword();
}
