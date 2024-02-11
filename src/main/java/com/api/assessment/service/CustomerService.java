package com.api.assessment.service;

import com.api.assessment.entity.Customer;
import com.api.assessment.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerService {
    private final CustomerRepository CustomerRepository;
    public CustomerService(CustomerRepository CustomerRepository){
        this.CustomerRepository = CustomerRepository;
    }

    public List<Customer> getAll(){
        return  this.CustomerRepository.findAll();
    }

    public void save(Customer customer){
        this.CustomerRepository.save(customer);
    }

    public void delete(String customerID){
        this.CustomerRepository.deleteById(customerID);
    }

    public void update(Customer customer){
        this.CustomerRepository.save(customer);
    }
}
