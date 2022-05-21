package uz.pdp.appdatarestpcmarketuz.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appdatarestpcmarketuz.entity.Product;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDto {
    @NotNull(message = "key bo'sh bo'lmasligi kerak!")
    private String key;

    @NotNull(message = "value bo'sh bo'lmasligi kerak!")
    private String value;

    private Integer productId;
}
