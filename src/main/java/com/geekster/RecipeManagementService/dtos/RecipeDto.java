package com.geekster.RecipeManagementService.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {

    @NotNull
    private String name;
    @Size(min = 5,max = Integer.MAX_VALUE,message = "give proper ingredients")
    private String ingredients;
    private String instructions;

    private String email;
    private String token;

}
