package com.example.projectcourse.service;

import com.example.projectcourse.model.Customer;
import com.example.projectcourse.model.Plan;
import com.example.projectcourse.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(long id){
        Optional<Customer> c=customerRepository.findById(id);
        return c.get();
    }

    public Customer getCustomerByUsername(String userName){
        Optional<Customer> c=customerRepository.findCustomerByUserName(userName);
        return c.get();
    }

    public void addCustomer(Customer customer){
        String password= passwordEncoder.encode(customer.getPassword());
        customer.setPassword(password);


        customerRepository.save(customer);
    }




}