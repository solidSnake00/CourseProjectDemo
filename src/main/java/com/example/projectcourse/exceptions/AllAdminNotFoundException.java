package com.example.projectcourse.exceptions;

public class AllAdminNotFoundException extends RuntimeException{

    public AllAdminNotFoundException(){
        super("All admin not found");
    }
}
