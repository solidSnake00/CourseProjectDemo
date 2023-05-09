package com.example.projectcourse.exceptions;

public class AllVideosNotFoundException extends RuntimeException{

    public AllVideosNotFoundException(){
        super("All videos not found");
    }
}
