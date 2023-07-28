package com.geekster.RecipeManagementService.services;

import com.geekster.RecipeManagementService.dtos.RecipeDto;
import com.geekster.RecipeManagementService.models.Recipe;
import com.geekster.RecipeManagementService.models.User;
import com.geekster.RecipeManagementService.models.UserAuthenticationToken;
import com.geekster.RecipeManagementService.repositories.IRecipeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private IRecipeRepo iRecipeRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthTokenService userAuthTokenService;

    public String addRecipe(RecipeDto recipeDto) {

        UserAuthenticationToken userAuthenticationToken = userAuthTokenService.getUserAuthTokenByToken(recipeDto.getToken());
        User user = userService.getUserByEmail(recipeDto.getEmail());
        if(userAuthenticationToken != null && user != null) {
            Recipe recipe = new Recipe(recipeDto.getName(),recipeDto.getIngredients(),recipeDto.getInstructions(),user);
            iRecipeRepo.save(recipe);
            return "saved recipe successfully";
        }else {
            return "Invalid tokenId or userId,Kindly give correct tokenId or userId";
        }
    }

    public List<Recipe> getAllRecipeBySpecificUser(String email) {

        User user = userService.getUserByEmail(email);
        if(user == null) {
            return null;
        }
        return iRecipeRepo.getAllRecipeByEmail(user.getEmail());
    }

    @Transactional
    public boolean isDeleted(String token, String recipeName) {

        UserAuthenticationToken userAuthenticationToken = userAuthTokenService.getUserAuthTokenByToken(token);
        Recipe recipe = iRecipeRepo.findByRecipeName(recipeName);
        if(userAuthenticationToken != null && recipe != null) {
            iRecipeRepo.deleteByRecipeName(recipeName);
            return true;
        }
        return false;
    }

    @Transactional
    public String updateIngredientsByRecipeId(Long id, String ingredients) {

        if(id == null && ingredients == null) {
            return "Recipe Id or ingredients should not be null";
        }
        Recipe recipe = iRecipeRepo.findById(id).get();
        if(recipe != null) {
            recipe.setIngredients(ingredients);
            iRecipeRepo.save(recipe);
            return "updated ingredients successfully";
        }
        return "This recipe id does not present";
    }

    public List<Recipe> getAllRecipe() {
        return iRecipeRepo.findAll();
    }
}
