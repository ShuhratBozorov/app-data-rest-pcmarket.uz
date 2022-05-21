package uz.pdp.appdatarestpcmarketuz.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarestpcmarketuz.entity.Customer;

@Projection(types = Customer.class)
public interface CustomCustomer {
    Integer getId();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPhoneNumber();
}
