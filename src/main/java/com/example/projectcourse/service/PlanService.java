package com.example.projectcourse.service;

import com.example.projectcourse.exceptions.AllCustomersNotFoundException;
import com.example.projectcourse.exceptions.PlanNotFoundException;
import com.example.projectcourse.model.Plan;
import com.example.projectcourse.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    private final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> getAllPlans(){
        try {
            return planRepository.findAll();
        } catch (Exception e) {
            throw new AllCustomersNotFoundException();
        }

    }

    public Plan getPlanById(long id){
        try {
            Optional<Plan> plan=planRepository.findById(id);
            return plan.get();
        } catch (Exception e) {
            throw new PlanNotFoundException(id);
        }

    }

    public void addPlan(Plan plan){
        planRepository.save(plan);
    }

    public void deletePlan(Plan plan){
        planRepository.delete(plan);
    }

    public void updatePlan(Plan plan){
        planRepository.save(plan);
    }
}
