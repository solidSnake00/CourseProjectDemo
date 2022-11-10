package com.example.projectcourse.service;

import com.example.projectcourse.model.User;
import com.example.projectcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
       return userRepository.findAll();
    }

    public User getUserById(long id){
        Optional<User> userOptional=userRepository.findById(id);
        return userOptional.get();
    }

    public void addUser(User user){
        userRepository.save(user);
    }
}
