package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static kodlama.io.ecommerce.entities.enums.Status.AVAILABLE;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;


    public void validateProduct(Product product){
        checkIfUnitPriceValid(product);
        checkIfDescriptionLengthValid(product);
        checkIfQuantityValid(product);
    }


    public void checkIfProductExists(int id) {
        if (!repository.existsById(id)) throw new RuntimeException("böyle bir ürün mevcut değil.");
    }

    private void checkIfDescriptionLengthValid(Product product) {
        if(product.getDescription().length() <10 || product.getDescription().length()>50)
            throw new RuntimeException("description length must be between 10 and 50 characters");
    }

    private void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0)
            throw new RuntimeException("quantity cannot be less than zero");
    }

    private void checkIfUnitPriceValid(Product product) {
        if (product.getUnitPrice() <= 0)
            throw new RuntimeException("price cannot be less than or equal to zero");
    }

    private void checkIfAvailable(int id) {
        Product product = repository.findById(id).orElseThrow();
        if (!product.getStatus().equals(AVAILABLE))throw new RuntimeException("product is not available");

    }
}
