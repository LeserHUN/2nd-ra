package com.github.leser.sercive;

import com.github.leser.Validation.PositiveNumberValidation;
import com.github.leser.read.IntegerValidationReader;
import com.github.leser.repository.user.User;
import com.github.leser.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j

public class WithdrawService {
    private final IntegerValidationReader integerValidationReader;
    private final PositiveNumberValidation positiveNumberValidation;
    private final UserRepository userRepository;

    public void withdraw(User user){
        System.out.println("How much do you want to withdraw? " + user.getBalance());
        int withdrawValue = integerValidationReader.readNumber(positiveNumberValidation);

        if (withdrawValue > user.getBalance()){
            System.err.println("You cannot withdraw so much");
            withdraw(user);
            return;
        }

        user.decreaseBalance(withdrawValue);
        userRepository.save(user);
        System.out.println("Withdrawed successfuly");
    }

}
