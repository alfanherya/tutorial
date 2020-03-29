package com.herya.rest.controller;

import com.herya.rest.data.Customer;
import com.herya.rest.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired CustomersService customersService;
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customers = customersService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @PostMapping(value = "/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        final Customer customerData = customersService.createCustomer(customer);
        return new ResponseEntity<>(customerData, HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        customersService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Customer customer = customersService.getCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
