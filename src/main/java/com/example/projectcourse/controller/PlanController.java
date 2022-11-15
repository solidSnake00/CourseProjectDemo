package com.example.projectcourse.controller;

import com.example.projectcourse.model.Plan;
import com.example.projectcourse.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/plan")
public class PlanController {

    @Autowired
    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/all")
    public List<Plan> displayAllPlans(){
        return planService.getAllPlans();
    }

    @GetMapping("/id/{id}")
    public Plan displayPlan(@PathVariable long id){
        return planService.getPlanById(id);
    }

    @PostMapping("/create")
    public void createPlan(@RequestBody @Valid Plan plan){
        planService.addPlan(plan);
    }

    @DeleteMapping("/id/{id}")
    public void deletePlan(@PathVariable long id){
        Plan plan=planService.getPlanById(id);
        planService.deletePlan(plan);
    }

    @PutMapping("/update")
    public void updatePlan(@RequestBody @Valid Plan plan){
        planService.updatePlan(plan);
    }
}