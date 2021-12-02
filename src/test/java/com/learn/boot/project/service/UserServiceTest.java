package com.learn.boot.project.service;

import com.learn.boot.project.dao.UserDao;
import com.learn.boot.project.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        User user = User.builder()
                .userFirstName("tata")
                .userLastName("fafa")
                .build();

        List<User> foundUsers =  List.of(user);
        Mockito.when(userDao.findByUserFirstNameIgnoreCase("tata")).thenReturn(foundUsers);
    }

    @Test
    @DisplayName("Get data based on User Name")
    public void whenValidUserName_thenUserShouldFound(){
        String userFirstName = "tata";
        List<User> foundUsers = userService.fetchUserByFirstName("tata");
        for(User user : foundUsers){
            assertEquals(userFirstName,user.getUserFirstName());
        }
    }
}