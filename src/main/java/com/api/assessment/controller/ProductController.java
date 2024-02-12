package com.api.assessment.controller;

import com.api.assessment.entity.Product;
import com.api.assessment.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<Product> save(@RequestBody Product product){
        Product product1 = this.productService.save(product);
        return ResponseEntity.ok().body(product1);
    }
    @DeleteMapping
    public ResponseEntity delete(@RequestParam String productID){
        this.productService.delete(productID);
        return ResponseEntity.ok().body("Delete Product Successfully");
    }
    @PutMapping
    public ResponseEntity update(@RequestBody Product product){
        this.productService.update(product);
        return ResponseEntity.ok().body("Update Product Successfully");
    }
}
