package com.example.projectcourse;

import com.example.projectcourse.model.Customer;
import com.example.projectcourse.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;


    @Test
    public void addCustomerTest(){

        Customer customer=customerService.getCustomerById(6);

		Assertions.assertThat(customer).isNotNull();
    }
}
