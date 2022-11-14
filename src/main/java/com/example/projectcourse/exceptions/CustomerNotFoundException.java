package com.example.projectcourse.exceptions;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(long id){

        super(String.format("Customer with id %d not found",id));
    }

    public CustomerNotFoundException(String userName){

        super(String.format("Customer with username %s not found",userName));
    }
}
