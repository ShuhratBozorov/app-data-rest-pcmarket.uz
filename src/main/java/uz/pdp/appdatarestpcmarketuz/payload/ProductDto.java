package uz.pdp.appdatarestpcmarketuz.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appdatarestpcmarketuz.entity.Brand;
import uz.pdp.appdatarestpcmarketuz.entity.Category;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotNull(message = "productName bo'sh bo'lmasligi kerak!")
    private String name;

    private Integer brandId;

    private Integer categoryId;
}
