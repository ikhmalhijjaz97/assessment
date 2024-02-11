package com.api.assessment.controller;

import com.api.assessment.entity.Customer;
import com.api.assessment.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping
    public List<Customer> getAll(){
        return this.customerService.getAll();
    }
    @PostMapping
    public void save(@RequestBody Customer customer){
        System.out.println("Email :"+ customer.getEmail());
        this.customerService.save(customer);
    }
    @DeleteMapping
    public void delete(@RequestParam String customerID){
        System.out.println("customerID : "+ customerID);
        this.customerService.delete(customerID.toString());
    }
    @PutMapping
    public void update(@RequestBody Customer customer){
        this.customerService.update(customer);
    }
}
