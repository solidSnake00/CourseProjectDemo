package com.example.projectcourse.controller;

import com.example.projectcourse.model.Customer;
import com.example.projectcourse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Customer displayCustomer(@PathVariable String username){
        return customerService.getCustomerByUsername(username);
    }

    @PostMapping("/create")
    public void createCustomer(@RequestBody @Valid Customer customer) {
        customerService.addCustomer(customer);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody @Valid Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/id/{id}")
    public void deleteCustomer(@PathVariable long id){
        Customer customer=customerService.getCustomerById(id);
        customerService.deleteCustomer(customer);
    }

    @DeleteMapping("/username/{username}")
    public void deleteCustomer(@PathVariable String username){
        Customer customer=customerService.getCustomerByUsername(username);
        customerService.deleteCustomer(customer);
    }

}