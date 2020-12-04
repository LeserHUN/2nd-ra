package com.github.leser.config;

import com.github.leser.repository.user.User;
import com.github.leser.repository.user.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
@Data
@Configuration
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "registration")
public class DefaultUserConfiguration {
    private final UserRepository userRepository;

    private List<User> defaultUsers;

    @PostConstruct
    public void addDefaultUsers(){
        for(User user : defaultUsers){
            userRepository.save(user);
        }
    }
}
