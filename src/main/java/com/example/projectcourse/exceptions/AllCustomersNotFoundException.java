package com.example.projectcourse.exceptions;

public class AllCustomersNotFoundException extends RuntimeException{

    public AllCustomersNotFoundException(){

        super("All customers don't exist");
    }
}
