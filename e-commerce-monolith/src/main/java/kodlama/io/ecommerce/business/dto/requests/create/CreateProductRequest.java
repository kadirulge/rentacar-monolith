package kodlama.io.ecommerce.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    @Min(0)
    private List<Integer> categoryIds;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @Min(0)
    private int quantity;
    @Min(1)
    private double unitPrice;
    @NotBlank
    @Size(min = 10, max = 50)
    private String description;
}
