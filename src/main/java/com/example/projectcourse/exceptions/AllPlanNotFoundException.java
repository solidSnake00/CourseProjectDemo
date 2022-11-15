package com.example.projectcourse.exceptions;

public class AllPlanNotFoundException extends RuntimeException{

    public AllPlanNotFoundException(){
        super(String.format("All plans not found"));
    }
}
