package com.learn.boot.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    @NotBlank(message = "Please provide a user first name")
    private String userFirstName;

    @NotBlank(message = "Please provide a user last name")
    private String userLastName;
}
