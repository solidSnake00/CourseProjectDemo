package com.example.projectcourse.service;

import com.example.projectcourse.exceptions.AllCustomersNotFoundException;
import com.example.projectcourse.exceptions.CustomerNotFoundException;
import com.example.projectcourse.model.Customer;
import com.example.projectcourse.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
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
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            throw new AllCustomersNotFoundException();
        }
    }

    public Customer getCustomerById(long id){
        try{
            Optional<Customer> c=customerRepository.findById(id);
            return c.get();
        } catch (Exception e) {
            throw new CustomerNotFoundException(id);
        }

    }

    public Customer getCustomerByUsername(String userName){
        try{
            Optional<Customer> c=customerRepository.findCustomerByUserName(userName);
            return c.get();
        } catch (Exception e) {
            throw new CustomerNotFoundException(userName);
        }

    }

    public void addCustomer(@NotNull Customer customer){
        String password= passwordEncoder.encode(customer.getPassword());
        customer.setPassword(password);

        customerRepository.save(customer);
    }

}