package kodlama.io.ecommerce.business.dto.responses.update;

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
public class UpdateProductResponse {
    private int id;
    private List<Integer> categoryIds;
    private String name;
    private int quantity;
    private Status status;
    private double unitPrice;
    private String description;

}
