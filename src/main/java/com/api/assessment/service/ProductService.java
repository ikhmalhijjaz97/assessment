package com.api.assessment.service;

import com.api.assessment.entity.Product;
import com.api.assessment.exception.APIErrorException;
import com.api.assessment.exception.ProductNotFoundException;
import com.api.assessment.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final Logger logger = LogManager.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        logger.info(CustomerService.class +" Fetching All Product");
        try{
            return this.productRepository.findAll();
        }catch (Exception e){
            logger.error(CustomerService.class + " error occur when fetching products :" + e);
            throw new APIErrorException("Please Contact Developer");
        }
    }

    public Product save(Product product){
        logger.info(CustomerService.class +" Save New Product");
        try{
            return this.productRepository.save(product);
        }catch (Exception e){
            logger.error(CustomerService.class + " error occur when saving products :" + e);
            throw new APIErrorException("Please Contact Developer");
        }
    }

    public void delete(String productID){
        logger.info(CustomerService.class +" Delete Product with productID :"+productID);
        try{
            if(this.productRepository.findById(productID).isEmpty()){
                throw new ProductNotFoundException("Product Not Found");
            }
            this.productRepository.deleteById(productID);
        }catch (ProductNotFoundException e){
            logger.error(CustomerService.class +" product not found with productID: "+productID+ "error: " + e);
            throw new ProductNotFoundException("Product Not Found");
        }catch (Exception e){
            logger.error(CustomerService.class +" error occur when deleting product data with productID: "+productID+ "error: " + e);
            throw new APIErrorException("Please Contact Developer");
        }
    }

    public void update(Product product){
        logger.info(CustomerService.class +" Update Product with productID :"+product.getProductID());
        try{
            if(this.productRepository.findById(product.getProductID()).isEmpty()){
                throw new ProductNotFoundException("Product Not Found");
            }
            this.productRepository.save(product);
        }catch (ProductNotFoundException e){
            logger.error(CustomerService.class +" product not found with productID: "+product.getProductID()+ "error: " + e);
            throw new ProductNotFoundException("Product Not Found");
        }catch (Exception e){
            logger.error(CustomerService.class +" error occur when deleting product data with productID: "+product.getProductID()+ "error: " + e);
            throw new APIErrorException("Please Contact Developer");
        }
    }
}
