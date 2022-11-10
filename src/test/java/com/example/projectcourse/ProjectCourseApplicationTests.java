package com.example.projectcourse;

import com.example.projectcourse.model.Customer;
import com.example.projectcourse.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectCourseApplicationTests {
	@Autowired
	private CustomerService customerService;

	@Test
	void contextLoads() {
	}

	@Test
	public void addCustomerTest(){

		Customer customer=customerService.getCustomerById(2);

		Assertions.assertThat(customer).isNotNull();
	}

}
