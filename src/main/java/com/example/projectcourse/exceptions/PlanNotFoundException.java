package com.example.projectcourse.exceptions;

public class PlanNotFoundException extends RuntimeException{

    public PlanNotFoundException(long id){
        super(String.format("Plan with id %d is not found",id));
    }
}
