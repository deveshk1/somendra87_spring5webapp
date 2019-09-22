package com.codelabs.springbootapplication.exception;

public class StudentException extends RuntimeException
{
    private String message;

    public StudentException(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
