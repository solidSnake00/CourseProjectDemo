package com.example.projectcourse.service;

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
        return planRepository.findAll();
    }

    public Plan getPlanById(long id){
        Optional<Plan> plan=planRepository.findById(id);
        return plan.get();
    }

    public void addPlan(Plan plan){
        planRepository.save(plan);
    }
}
