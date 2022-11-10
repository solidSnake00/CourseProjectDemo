package com.example.projectcourse.repository;

import com.example.projectcourse.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public Optional<Customer> findCustomerByUserName(String userName);

}
