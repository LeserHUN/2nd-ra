package com.github.leser.repository.user;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@Table(schema = "bank", name = "bank_user")
public class User {
    @Id
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
