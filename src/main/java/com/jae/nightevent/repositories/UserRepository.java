package com.jae.nightevent.repositories;

import com.jae.nightevent.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);
    User findByUserName(String name);
}
