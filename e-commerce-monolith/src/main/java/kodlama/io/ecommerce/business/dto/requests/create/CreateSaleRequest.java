package kodlama.io.ecommerce.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleRequest {
    @Min(0)
    private List<Integer> productIds;
    @Min(1)
    private double totalPrice;
}
