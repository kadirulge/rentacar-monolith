package kodlama.io.ecommerce.business.dto.requests.update;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSaleRequest {
    @Min(0)
    private List<Integer> productIds;
    @Min(1)
    private double totalPrice;
    //TODO: notFuture
    private LocalDateTime purchasedAt;
}
