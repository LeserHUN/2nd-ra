package com.github.leser.menu;

import com.github.leser.Validation.PasswordValidation;
import com.github.leser.Validation.UsernameValidation;
import com.github.leser.read.ValidationReader;
import com.github.leser.repository.user.User;
import com.github.leser.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor

public class RegistrationMenu implements Menu{
private final ValidationReader validationReader;
private final UsernameValidation usernameValidation;
private final PasswordValidation passwordValidation;
private final UserRepository userRepository;


@Value("${registration.startBalance}")
private int startBalance;

    @Override
    public void enterMenu() {
        System.out.println();
        System.out.println("Register user...");
        System.out.println("Username");
        String username = validationReader.rearInput(usernameValidation);

        System.out.println();
        System.out.println("Password");
        String password = validationReader.rearInput(passwordValidation);


        User user = User.builder()
                .username(username)
                .password(password)
                .balance(startBalance)
                .build();
        userRepository.save(user);

        System.out.println("Registration succesful.");

    }
}
