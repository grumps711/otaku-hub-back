package com.ironhack.otakuhub.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("The user with ID " + id + " was not found");
    }


}
