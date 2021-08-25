package com.springboot.server.repository;

import com.springboot.server.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    void deleteUserByUserID(Long id);

    Optional<AppUser> findUserByUserID(Long id);

    AppUser findByUsername(String username);
}
