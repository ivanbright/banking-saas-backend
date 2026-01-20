package com.mugisha.bankingbackend.repository;

import com.mugisha.bankingbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String name);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
