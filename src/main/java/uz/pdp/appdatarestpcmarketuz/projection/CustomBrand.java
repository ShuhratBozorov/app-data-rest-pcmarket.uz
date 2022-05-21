package uz.pdp.appdatarestpcmarketuz.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarestpcmarketuz.entity.Brand;

@Projection(types = Brand.class)
public interface CustomBrand {

    Integer getId();

    String getName();
}
