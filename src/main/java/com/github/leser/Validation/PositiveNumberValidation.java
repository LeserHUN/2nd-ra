package com.github.leser.Validation;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class PositiveNumberValidation implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        if ((integer < 0)){
            System.out.println("Number must be positive.");
            return false;
        }
        return true;
    }
}
