package com.learn.boot.project.entities;

import javax.persistence.*;
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
@Table(name ="\"User\"")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    @NotBlank(message = "Please provide a user first name")
    private String userFirstName;

    @NotBlank(message = "Please provide a user last name")
    private String userLastName;
}
