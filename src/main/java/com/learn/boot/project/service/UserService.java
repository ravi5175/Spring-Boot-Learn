package com.learn.boot.project.service;

import java.util.List;
import java.util.Optional;

import com.learn.boot.project.entities.User;
import com.learn.boot.project.exception.custom_exception.UserNotFoundException;

public interface UserService {
    
    public User saveUser(User user);
    public List<User> fetchUsers();
    public Optional<User> fetchUserById(Long id) throws UserNotFoundException;
    public void deleteUser(Long id);
    public User updateUser(Long id, User user);
    
    public List<User> fetchUserByFirstName(String firstName);
}
