package com.geekster.RecipeManagementService.repositories;

import com.geekster.RecipeManagementService.models.UserAuthenticationToken;
import org.springframework.data.repository.ListCrudRepository;

public interface IUserAuthTokenRepo extends ListCrudRepository<UserAuthenticationToken,Long> {
    UserAuthenticationToken findByAuthToken(String token);
}
