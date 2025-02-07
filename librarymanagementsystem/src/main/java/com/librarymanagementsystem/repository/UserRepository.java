package com.librarymanagementsystem.repository;

import com.librarymanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUniversityId(Long universityId);

    Optional<User> findByEmail(String email);

}
