package com.github.leser.Validation;

import com.github.leser.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Component
@RequiredArgsConstructor
public class UsernameValidation implements Predicate<String> {
    private final UserRepository userRepository;

    @Override
    public boolean test(String username){
        boolean result = true;

        if(isBlank(username)) {
            System.out.println("Username must contain at least one character");
            result = false;
        }

        if(userRepository.usernameExists(username)){
          System.out.println("Username already in use.");
          result = false;
        }
        return result;
    }
}
