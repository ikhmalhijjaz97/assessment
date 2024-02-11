package com.api.assessment.service;

import com.api.assessment.entity.Product;
import com.api.assessment.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

    public void save(Product product){
        this.productRepository.save(product);
    }

    public void delete(String productID){
        this.productRepository.deleteById(productID);
    }

    public void update(Product product){
        this.productRepository.save(product);
    }
}
