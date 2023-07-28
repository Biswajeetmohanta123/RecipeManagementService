package com.geekster.RecipeManagementService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserAuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authTokenId;
    private String authToken;
    private LocalDateTime generatedDateTime;

    @OneToOne
    private User user;


    public UserAuthenticationToken(User user) {
        this.user = user;
        this.authToken = UUID.randomUUID().toString();
        this.generatedDateTime = LocalDateTime.now();
    }
}
