package com.example.projectcourse.exceptions;

public class AdminNotFoundException extends RuntimeException{

    public AdminNotFoundException(long id){
        super(String.format("Admin with id %d not found",id));
    }

    public AdminNotFoundException(String userName){
        super(String.format("Admin with username %s not found",userName));
    }
}
