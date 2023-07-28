package com.geekster.RecipeManagementService.services;

import com.geekster.RecipeManagementService.models.UserAuthenticationToken;
import com.geekster.RecipeManagementService.repositories.IUserAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthTokenService {

    @Autowired
    private IUserAuthTokenRepo iUserAuthTokenRepo;


    public boolean saveToken(UserAuthenticationToken userAuthenticationToken) {
        iUserAuthTokenRepo.save(userAuthenticationToken);
        return true;
    }

    public boolean isAuthenticated(String email, String token) {
        UserAuthenticationToken userAuthenticationToken = iUserAuthTokenRepo.findByAuthToken(token);
        String databaseEmail = userAuthenticationToken.getUser().getEmail();
            if(userAuthenticationToken != null && databaseEmail.equals(email)) {
                return true;
            }else{
                return false;
            }
    }

    public void deleteToken(String token) {
        UserAuthenticationToken userAuthenticationToken = iUserAuthTokenRepo.findByAuthToken(token);
        iUserAuthTokenRepo.deleteById(userAuthenticationToken.getAuthTokenId());
    }

    public UserAuthenticationToken getUserAuthTokenByToken(String token) {
        return iUserAuthTokenRepo.findByAuthToken(token);
    }
}

