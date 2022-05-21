package uz.pdp.appdatarestpcmarketuz.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarestpcmarketuz.entity.Product;
import uz.pdp.appdatarestpcmarketuz.entity.ProductInfo;

@Projection(types = ProductInfo.class)
public interface CustomProductInfo {

    Integer getId();

    String getKey();

    String getValue();

    Product getProduct();
}
