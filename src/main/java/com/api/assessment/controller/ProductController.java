package com.api.assessment.controller;

import com.api.assessment.entity.Product;
import com.api.assessment.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/product")

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAll(){
        return this.productService.findAll();
    }
    @PostMapping
    public void save(@RequestBody Product product){
        this.productService.save(product);
    }
    @DeleteMapping
    public void delete(@RequestParam String productID){
        this.productService.delete(productID);
    }
    @PutMapping
    public void update(@RequestBody Product product){
        this.productService.update(product);
    }
}
