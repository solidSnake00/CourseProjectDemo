package com.example.projectcourse.service;

import com.example.projectcourse.model.*;
import com.example.projectcourse.repository.PlanRegistrationRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlanRegistrationService {
    private final PlanRegistrationRepository planRegistrationRepository;

    @Autowired
    public PlanRegistrationService(PlanRegistrationRepository planRegistrationRepository) {
        this.planRegistrationRepository = planRegistrationRepository;
    }

    public List<PlanRegistration> getAllPlanRegistrations(){
        return planRegistrationRepository.findAll();
    }

    public PlanRegistration getPlanRegistrationById(PlanRegistrationKey id){
        Optional<PlanRegistration> planRegistrationOptional=planRegistrationRepository.findById(id);
        return planRegistrationOptional.get();
    }

    public void addPlanRegistration(@NotNull PlanRegistration planRegistration, Customer customer, Plan plan){
        LocalDate localDate=LocalDate.now();
        planRegistration.setPurchaseDate(localDate);



        LocalDate localDate1= LocalDate.now().plusMonths(plan.getMonthDuration());
        planRegistration.setExpirationDate(localDate1);
        planRegistration.setCustomer(customer);
        planRegistration.setPlan(plan);

        planRegistration.setTotalPrice(plan.getPrice());

        planRegistration.setPaymentMethod(PaymentMethod.PAYPAL);

        planRegistrationRepository.save(planRegistration);
    }

}