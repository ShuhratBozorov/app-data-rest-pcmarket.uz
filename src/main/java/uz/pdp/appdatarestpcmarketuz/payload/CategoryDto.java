package uz.pdp.appdatarestpcmarketuz.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appdatarestpcmarketuz.entity.Category;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotNull(message = "categoryName bo'sh bo'lmasligi kerak!")
    private String name;

    private boolean active;

    private Integer parentCategoryId;
}
