package com.github.leser.repository.user;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String> {


    boolean existsByUsername(String username);

    User findByUsername(String username);


}
