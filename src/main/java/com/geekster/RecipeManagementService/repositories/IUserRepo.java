package com.geekster.RecipeManagementService.repositories;

import com.geekster.RecipeManagementService.models.User;
import org.springframework.data.repository.ListCrudRepository;

public interface IUserRepo extends ListCrudRepository<User,Long> {
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
