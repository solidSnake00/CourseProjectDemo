package com.example.projectcourse.controller;

import com.example.projectcourse.model.Customer;
import com.example.projectcourse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<Customer> displayAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/id/{id}")
    public Customer displayCustomer(@PathVariable long id){
        return customerService.getCustomerById(id);

    }

    @GetMapping("/username/{username}")
    public Customer displayCustomerUsername(@PathVariable String username){
        return customerService.getCustomerByUsername(username);

    }
}