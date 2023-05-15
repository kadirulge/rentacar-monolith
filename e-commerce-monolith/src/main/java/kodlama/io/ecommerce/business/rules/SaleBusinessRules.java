package kodlama.io.ecommerce.business.rules;

import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import kodlama.io.ecommerce.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static kodlama.io.ecommerce.entities.enums.Status.AVAILABLE;

@Service
@AllArgsConstructor
public class SaleBusinessRules {
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;

    public void checkQuantity(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        if (product.getQuantity() < 0) throw new RuntimeException("quantity is not enough");
    }

    public void checkIfAvailable(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        if (!product.getStatus().equals(AVAILABLE))throw new RuntimeException("product is not available");

    }

    public void checkIfSaleExists(int id) {
        if (!saleRepository.existsById(id)) throw new RuntimeException("böyle bir satış mevcut değil.");
    }

    public void isValidForSale(List<Product> products) {
        for (Product product : products) {
            checkQuantity(product.getId());  //TODO: make prettier
            checkIfAvailable(product.getId());
        }
    }

}
