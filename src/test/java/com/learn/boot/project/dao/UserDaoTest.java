package com.learn.boot.project.dao;

import com.learn.boot.project.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        User user = User.builder()
                .userFirstName("ravi")
                .userLastName("pawar")
                .build();

        entityManager.persist(user);
    }

    @Test
    public void whenFindUserById(){
        User user = userDao.findById(1L).get();
        assertEquals(user.getUserFirstName(),"ravi");
    }
}