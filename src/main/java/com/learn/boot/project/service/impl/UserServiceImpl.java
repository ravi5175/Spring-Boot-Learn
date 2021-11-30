package com.learn.boot.project.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.learn.boot.project.entities.User;
import com.learn.boot.project.exception.custom_exception.UserNotFoundException;
import com.learn.boot.project.dao.UserDao;

import com.learn.boot.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepo;
    
    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> fetchUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> fetchUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepo.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found exception");
        }
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        User currUserDetails = userRepo.findById(id).get();

        if(Objects.nonNull(user.getUserFirstName())&& !"".equalsIgnoreCase(user.getUserFirstName())){
            currUserDetails.setUserFirstName(user.getUserFirstName());
        }

        if(Objects.nonNull(user.getUserLastName())&& !"".equalsIgnoreCase(user.getUserLastName())){
            currUserDetails.setUserLastName(user.getUserLastName());
        }
        return userRepo.save(currUserDetails);
    }

    @Override
    public List<User> fetchUserByFirstName(String firstName) {
        return userRepo.findByUserFirstNameIgnoreCase(firstName);
    }
}
