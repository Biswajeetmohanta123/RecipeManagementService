package com.geekster.RecipeManagementService.repositories;

import com.geekster.RecipeManagementService.models.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

public interface IRecipeRepo extends ListCrudRepository<Recipe,Long> {

//    custom native query
    @Query(value = "select * from recipe\n" +
            "inner join users\n" +
            "on recipe.fk_user_id = users.id\n" +
            "where users.email = :email",nativeQuery = true)
    List<Recipe> getAllRecipeByEmail(String email);


    Recipe findByRecipeName(String recipeName);

    void deleteByRecipeName(String recipeName);
}
