package com.geekster.RecipeManagementService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;
    private String recipeName;
    private String ingredients;
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    public Recipe(String name, String ingredients, String instructions, User user) {
        this.recipeName = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.user = user;
    }
}
