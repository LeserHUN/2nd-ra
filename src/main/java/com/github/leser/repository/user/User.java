package com.github.leser.repository.user;


import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private int balance;

    public void increaseBalance(int value) {
        balance += value;
    }
    public void decreaseBalance(int value){
        balance -= value;
    }
}
