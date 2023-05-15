package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.SaleService;
import kodlama.io.ecommerce.business.dto.requests.create.CreateSaleRequest;
import kodlama.io.ecommerce.business.dto.responses.create.CreateSaleResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetAllSalesResponse;
import kodlama.io.ecommerce.business.dto.responses.get.GetSaleResponse;
import kodlama.io.ecommerce.business.dto.responses.update.UpdateSaleResponse;
import kodlama.io.ecommerce.business.rules.SaleBusinessRules;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.entities.Sale;
import kodlama.io.ecommerce.repository.ProductRepository;
import kodlama.io.ecommerce.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleManager implements SaleService {

    private final SaleRepository repository;
    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    private final SaleBusinessRules rules;

    @Override
    public List<GetAllSalesResponse> getAll() {
        List<Sale>sales = repository.findAll();
        List<GetAllSalesResponse> response = sales
                .stream()
                .map(sale -> mapper.map(sale, GetAllSalesResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetSaleResponse getById(int id) {
        rules.checkIfSaleExists(id);
        Sale sale = repository.findById(id).orElseThrow();
        GetSaleResponse response = mapper.map(sale, GetSaleResponse.class);
        return response;
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request) {
        Sale sale = mapper.map(request, Sale.class);
        List<Product> products = sale.getProducts();
        rules.isValidForSale(products);
        sale.setId(0);
        repository.save(sale);
        CreateSaleResponse response = mapper.map(sale, CreateSaleResponse.class);
        return response;
    }


    @Override
    public UpdateSaleResponse update(int id, CreateSaleRequest request) {
        rules.checkIfSaleExists(id);
        Sale sale = mapper.map(request, Sale.class);
        List<Product> products = sale.getProducts();
        rules.isValidForSale(products);
        sale.setId(id);
        Sale updatedSale = repository.save(sale);
        UpdateSaleResponse response = mapper.map(updatedSale, UpdateSaleResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfSaleExists(id);
        repository.deleteById(id);
    }
}
