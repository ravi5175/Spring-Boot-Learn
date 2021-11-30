package com.learn.boot.project.dao;

import java.util.List;

import com.learn.boot.project.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    
    public List<User> findByUserFirstNameIgnoreCase(String userFirstName);
}
