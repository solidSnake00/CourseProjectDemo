package com.example.projectcourse;

import com.example.projectcourse.model.*;
import com.example.projectcourse.service.CourseService;
import com.example.projectcourse.service.CustomerService;
import com.example.projectcourse.service.PlanRegistrationService;
import com.example.projectcourse.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class ProjectCourseApplication {

	@Autowired
	private static CustomerService customerService;

	private static CourseService courseService;

	private static PlanService planService;

	private static PlanRegistrationService planRegistrationService;

	public ProjectCourseApplication(CustomerService customerService, CourseService courseService, PlanService planService, PlanRegistrationService planRegistrationService){
		this.customerService = customerService;
		this.courseService=courseService;
		this.planService=planService;
		this.planRegistrationService=planRegistrationService;

	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectCourseApplication.class, args);

		/*Customer customer= Customer.builder()
				.firstName("Samer2")
				.lastName("Baroudi")
				.email("samerbaroudi222@hotmail.com")
				.userName("test3238")
				.password("encryptedpassword")
				.customerStatus(CustomerStatus.NOTREGISTERED)
				.creationDate(LocalDate.now())
				.build();

		customerService.addCustomer(customer);

		PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

		boolean ppp=passwordEncoder.matches("encryptedpassword", customer.getPassword()); //customer.getPassword();

		System.out.println(ppp);*/

		Plan plan=planService.getPlanById(4);

		Customer customer=customerService.getCustomerByUsername("test3238");

		PlanRegistrationKey planRegistrationKey=new PlanRegistrationKey();
		planRegistrationKey.setCustomerId(customer.getId());
		planRegistrationKey.setPlanId(plan.getId());

		PlanRegistration planRegistration=new PlanRegistration();
		planRegistration.setId(planRegistrationKey);


		planRegistrationService.addPlanRegistration(planRegistration,customer,plan);



	}

}
