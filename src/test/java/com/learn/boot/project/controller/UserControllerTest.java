package com.learn.boot.project.controller;

import com.learn.boot.project.entities.User;
import com.learn.boot.project.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp(){
        user = User.builder()
                .userFirstName("Ravi")
                .userLastName("Pawar")
                .build();
    }
//    @Test
//    void getUsers() {
//    }
//
//    @Test
//    void getUserById() {
//    }
//
//    @Test
//    void fetchUserByFirstName() {
//    }

//    @Test
//    void saveUser() throws Exception {
//        User inputUser = User.builder()
//                .userFirstName("Ravi")
//                .userLastName("Pawar")
//                .build();
//
//        Mockito.when(userService.saveUser(inputUser)).thenReturn(user);
//        mockMvc.perform(post("/"))
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{   \n" +
//                        "    \"userFirstName\" : \"tata\",\n" +
//                        "    \"userLastName\" : \"fafa\"\n" +
//                        "}")
//                .andExpect(status().isOk());
//    }

//    @Test
//    void deleteUser() {
//    }
//
//    @Test
//    void updateUser() {
//    }
}