package kodlama.io.ecommerce.api.controllers;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService service;


    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return service.getById(id);
    }

 /*   @GetMapping("/")
    public Product getById2(@RequestParam int id) {
        return service.getById(id);
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Product product) {
        service.add(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Product product,
                       @PathVariable int id) {
        service.update(product, id);
    }


}
