package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.CheckProductService;
import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository repository;
    private CheckProductService service;



    @Override
    public Product add(Product product) {

/*        if (!service.isValid(product)) {

            throw new RuntimeException("hatalı kayit");
        } else {

            repository.addProduct(product);
            System.out.println("ürün basariyla eklendi");
        }

        return product;*/

        validateProduct(product);
        return repository.save(product);

    }

    @Override
    public void delete(int id) {
        checkIfProductExists(id);
        repository.deleteById(id);
    }

    @Override
    public Product update(Product product, int id) {
/*        if (repository.listProducts().size() == 0) {
            throw new RuntimeException("ürün yok");
        } else if (repository.findProductById(id) == null) {
            throw new RuntimeException("bu id ile ürün bulunamadi");
        } else if (!service.isValid(product)) {
            throw new RuntimeException("hatalı ürün bilgisi girdiniz, güncelleme yapilamadi");
        } else {
            repository.updateProduct(product, id);
            System.out.println("ürün basariyla güncellendi");
        }
        return product;*/
        checkIfProductExists(id);
        validateProduct(product);
        product.setId(id);
        repository.save(product);
        return product;


    }


    @Override
    public Product getById(int id) {

        checkIfProductExists(id);
        return repository.findById(id).orElseThrow();

    }

    @Override
    public List<Product> getAll() {
        if (repository.findAll().size() == 0) {
            throw new RuntimeException("ürün listesi bos");
        }
        return repository.findAll();
    }

//BUSINESS RULES

    private void checkIfProductExists(int id) {
        if (!repository.existsById(id)) throw new RuntimeException("Product not found with id: " + id);
    }
    private void validateProduct(Product product){
        checkIfUnitPriceValid(product);
        checkIfDescriptionLengthValid(product);
        checkIfQuantityValid(product);
    }

    private void checkIfDescriptionLengthValid(Product product) {
        if(product.getDescription().length() <10 || product.getDescription().length()>50)
            throw new IllegalArgumentException("description length must be between 10 and 50 characters");
    }

    private void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0)
            throw new IllegalArgumentException("quantity cannot be less than zero");
    }

    private void checkIfUnitPriceValid(Product product) {
        if (product.getUnitPrice() <= 0)
            throw new IllegalArgumentException("price cannot be less than or equal to zero");
    }
}
