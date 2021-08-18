package com.springboot.server.repository;

import com.springboot.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteUserByUserID(Long id);

    Optional<User> findUserByUserID(Long id);
}
