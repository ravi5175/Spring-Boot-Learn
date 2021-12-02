package com.learn.boot.project.controller;

import java.util.List;

import javax.validation.Valid;

import com.learn.boot.project.entities.User;
import com.learn.boot.project.exception.custom_exception.UserNotFoundException;
import com.learn.boot.project.service.impl.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value="/user")
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;

    @Value("${welcome.message}")
    private String welcome;

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/welcome")
    public String welcome(){
        return welcome;
    }

    @GetMapping("/")
    public List<User> getUsers(){
        LOGGER.info("get users called");
        return userService.fetchUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(
        @PathVariable("id") Long id ) throws UserNotFoundException {
        LOGGER.info("get users by id called");
        return userService.fetchUserById(id).get();
    }

    @GetMapping("/name/{name}")
    public List<User> fetchUserByFirstName( @PathVariable("name") String userName ){
        return userService.fetchUserByFirstName(userName);
    }

    @PostMapping("/")
    public User saveUser(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(
        @PathVariable Long id){
        try{
            userService.deleteUser(id);
        }catch(Exception e){
            return "Exception Occured while deleting user";
        }
        return "User "+id+" Delete Successful";
    }

    @PutMapping("/{id}")
    public User updateUser(
        @PathVariable Long id,
        @RequestBody User user
        ){
        return userService.updateUser(id,user);
    }
}
