package com.api.assessment.service;

import com.api.assessment.entity.Customer;
import com.api.assessment.exception.APIErrorException;
import com.api.assessment.exception.CustomerNotFoundException;
import com.api.assessment.repository.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository CustomerRepository;
    private final Logger logger = LogManager.getLogger(CustomerService.class);
    public CustomerService(CustomerRepository CustomerRepository){
        this.CustomerRepository = CustomerRepository;
    }

    public List<Customer> getAll(){
        logger.info(CustomerService.class +" Fetching All Customer");
        List<Customer> customerList = null;
        try{
            customerList = this.CustomerRepository.findAll();
        }catch (Exception e){
            logger.error(CustomerService.class + " error occur when fetching customers :" + e);
            throw new APIErrorException("Please Contact Developer");
        }
        return customerList;
    }

    public Customer save(Customer customer){
        logger.info(CustomerService.class +" Saving Customer");
        try{
            return this.CustomerRepository.save(customer);
        }catch (Exception e){
            logger.error(CustomerService.class + " error occur when saving customer data :" + e);
            throw new APIErrorException("Please Contact Developer");
        }
    }

    public void delete(String customerID){
        logger.info(CustomerService.class +" Delete Customer with customerID :"+ customerID);
        try{
            if(this.CustomerRepository.findById(customerID).isEmpty()){
                throw new CustomerNotFoundException("Customer ID does not exist");
            }
            this.CustomerRepository.deleteById(customerID);
        }catch (CustomerNotFoundException e){
            logger.error(CustomerService.class + " customer not found with customerID: "+customerID+ "error: " + e);
            throw new CustomerNotFoundException("Customer ID does not exist");
        }catch (Exception e){
            logger.error(CustomerService.class + " error occur when deleting customer data with customerID: "+customerID+ "error: " + e);
            throw new APIErrorException("Please Contact Developer");
        }

    }

    public void update(Customer customer){
        logger.info(CustomerService.class +" Update Customer Data with customerID :"+customer.getCustomerID());
        try{
            if(this.CustomerRepository.findById(customer.getCustomerID()).isEmpty()){
                throw new CustomerNotFoundException("Customer ID does not exist");
            }
            this.CustomerRepository.save(customer);
        }catch (CustomerNotFoundException e){
            logger.error(CustomerService.class + " customer not found with customerID: "+customer.getCustomerID()+ "error: " + e);
            throw new CustomerNotFoundException("Customer ID does not exist");
        }catch (Exception e){
            logger.error(CustomerService.class + " error occur when updating customer data with customerID: "+customer.getCustomerID()+ "error: " + e);
            throw new APIErrorException("Please Contact Developer");
        }
    }
}
