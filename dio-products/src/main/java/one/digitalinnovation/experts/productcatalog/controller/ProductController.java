package one.digitalinnovation.experts.productcatalog.controller;

import one.digitalinnovation.experts.productcatalog.model.Product;
import one.digitalinnovation.experts.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product create(@RequestBody Product body){
        return productRepository.save(body);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id) throws Exception {
        return productRepository.findById(id)
                .orElseThrow(() -> new Exception("Nao encontrado") );
    }
}
