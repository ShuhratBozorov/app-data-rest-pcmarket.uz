package uz.pdp.appdatarestpcmarketuz.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarestpcmarketuz.entity.Category;

@Projection(types = Category.class)
public interface CustomCategory {

    Integer getId();

    String getName();

    boolean getActive();

    Category getParentCategory();
}
