package com.example.projectcourse.exceptions;

public class VideoNotFoundException extends RuntimeException{

    public VideoNotFoundException(long id){
        super(String.format("Video with id %d not found",id));
    }
}
