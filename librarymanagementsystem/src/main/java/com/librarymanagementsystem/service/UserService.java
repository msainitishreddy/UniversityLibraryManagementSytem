package com.librarymanagementsystem.service;

import com.librarymanagementsystem.model.User;
import com.librarymanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserByUniversityId(Long universityId){
        return userRepository.findByUniversityId(universityId);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
