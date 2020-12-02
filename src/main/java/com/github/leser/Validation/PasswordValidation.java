package com.github.leser.Validation;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class PasswordValidation implements Predicate<String> {
    @Override
    public boolean test(String password){
       if (password.length() < 3){
           System.out.println("Password is too short(minimum 3 characters");
           return false;
       }
       return true;
    }
}
