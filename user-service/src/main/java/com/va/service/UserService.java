package com.va.service;

import com.va.domain.User;
import com.va.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void addNewUser(User User) {
        this.userRepository.save(User);
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElse(new User());
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User updateUser(Long id, User User) {
        if (this.userRepository.findById(id).isPresent()) {
            return this.userRepository.save(User);
        }
        return User;
    }

    public void deleteUser(Long id, User User) {
        if (this.userRepository.findById(id).isPresent()) {
            this.userRepository.delete(User);
        }
    }
}
