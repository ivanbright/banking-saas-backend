package com.mugisha.bankingbackend.service;

import com.mugisha.bankingbackend.model.User;
import com.mugisha.bankingbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Object createUser(User user) {
//        TODO: validation logic
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        if(userRepository.existsByPhone(user.getPhone())){throw new IllegalArgumentException("Phone already exists");}
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws Throwable {
        return (User) userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"));
    }

}
