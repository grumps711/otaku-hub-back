package com.ironhack.otakuhub.exception;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(String username){
        super("The user with username: " + username + " was not found");
    }


}
