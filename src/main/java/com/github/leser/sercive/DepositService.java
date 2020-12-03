package com.github.leser.sercive;

import com.github.leser.Validation.PositiveNumberValidation;
import com.github.leser.read.IntegerValidationReader;
import com.github.leser.repository.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DepositService {
    private final IntegerValidationReader integerValidationReader;
    private final PositiveNumberValidation positiveNumberValidation;

    public void deposit(User user){
        System.out.println("How much do you want to deposit?");
        int depositValue = integerValidationReader.readNumber(positiveNumberValidation);

        user.increaseBalance(depositValue);
    }
}
