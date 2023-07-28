package com.geekster.RecipeManagementService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;


    public User(String name, String email, String phoneNumber, String password) {
        this.username = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
