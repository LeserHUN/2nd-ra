package com.github.leser.sercive;


import com.github.leser.Validation.PositiveNumberValidation;
import com.github.leser.Validation.UserExistValidation;
import com.github.leser.read.IntegerValidationReader;
import com.github.leser.read.ValidationReader;
import com.github.leser.repository.user.User;
import com.github.leser.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransferService {
    private final IntegerValidationReader integerValidationReader;
    private final PositiveNumberValidation positiveNumberValidation;
    private final ValidationReader validationReader;
    private final UserExistValidation userExistValidation;
    private final UserRepository userRepository;

    public void transfer(User user) {
        System.out.println("How much do you want to transfer? Available balance is: " + user.getBalance());
        int transferValue = integerValidationReader.readNumber(positiveNumberValidation);

        if (transferValue == 0){
            System.out.println("Transaction cancelled");
            return;
        }

        if (transferValue > user.getBalance()) {
            System.err.println("You cannot transfer so much");
            transfer(user);
            return;
        }
        System.out.println("Who do you want to send money to? ");
        String username = validationReader.rearInput(userExistValidation);
        if (isBlank(username)){
            System.out.println("Transaction cancelled");
            return;
        }

        System.out.println(String.format("Transfering %s money to %s ", transferValue,username));
        User target = userRepository.findByUsername(username);

        target.increaseBalance(transferValue);
        user.decreaseBalance(transferValue);
        userRepository.save(user);
        userRepository.save(target);

        System.out.println("Transaction successful.");

    }

}
