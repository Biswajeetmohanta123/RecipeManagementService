package com.geekster.RecipeManagementService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignOutSignInOutput {

    private String status;
    private String token;
}
