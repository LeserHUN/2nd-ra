package com.github.leser.Validation;

import com.github.leser.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Component
@RequiredArgsConstructor
public class UserExistValidation implements Predicate<String> {
    private  final UserRepository userRepository;

    @Override
    public boolean test(String username) {

        if (isBlank(username)){
            return true;
        }
        boolean result = userRepository.existsByUsername(username);
        if (!result) {
            System.err.println("User not found");
        }
        return result;
    }
}
