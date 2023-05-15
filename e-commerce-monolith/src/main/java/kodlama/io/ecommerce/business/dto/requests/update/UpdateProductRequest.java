package kodlama.io.ecommerce.business.dto.requests.update;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kodlama.io.ecommerce.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    @Min(0)
    private List<Integer> categoryIds;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @Min(0)
    private int quantity;
    private Status status;
    @Min(1)
    private double unitPrice;
    @NotBlank
    @Size(min = 3, max = 255)
    private String description;
}
