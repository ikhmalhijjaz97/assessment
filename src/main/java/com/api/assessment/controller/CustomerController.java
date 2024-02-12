package com.api.assessment.controller;

import com.api.assessment.entity.Customer;
import com.api.assessment.service.CustomerService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Customer> save(@RequestBody Customer customer){

        Customer customer1 = this.customerService.save(customer);
        return ResponseEntity.ok().body(customer1);
    }
    @DeleteMapping
    public ResponseEntity delete(@RequestParam String customerID){
        this.customerService.delete(customerID.toString());
        return ResponseEntity.ok().body("Delete Customer Successfully with ID: "+ customerID);

    }
    @PutMapping
    public ResponseEntity update(@RequestBody Customer customer){

        this.customerService.update(customer);
        return ResponseEntity.ok().body("Delete Customer Successfully with ID: "+ customer.getCustomerID());
    }
}
