package com.geekster.RecipeManagementService.services;

import com.geekster.RecipeManagementService.dtos.SignInInput;
import com.geekster.RecipeManagementService.dtos.SignOutSignInOutput;
import com.geekster.RecipeManagementService.dtos.SignUpInput;
import com.geekster.RecipeManagementService.models.User;
import com.geekster.RecipeManagementService.models.UserAuthenticationToken;
import com.geekster.RecipeManagementService.repositories.IUserRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepo iUserRepo;

    @Autowired
    private UserAuthTokenService userAuthTokenService;

    public String signUp(SignUpInput signUpInput) {

        if(iUserRepo.existsByEmail(signUpInput.getEmail())) {
            return "Already signed up....Sign In instead";
        }

        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signUpInput.getPassword());
        }catch(Exception e) {
            e.printStackTrace();
        }

        User user = new User(signUpInput.getName(),signUpInput.getEmail(),signUpInput.getPhoneNumber(),encryptedPassword);
        iUserRepo.save(user);
        return "Signed up successfully";
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digested = md5.digest();
        return DatatypeConverter.printHexBinary(digested);
    }

    public SignOutSignInOutput signIn(SignInInput signInInput) {

        User user = iUserRepo.findByEmail(signInInput.getEmail());

        if(user == null) {
            return new SignOutSignInOutput("Invalid email ,please sign up....instead of signing in",null);
        }

        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signInInput.getPassword());
        }catch(Exception e) {
            e.printStackTrace();
        }

        if(!encryptedPassword.equals(user.getPassword())) {
            return new SignOutSignInOutput("Incorrect password",null);
        }

        UserAuthenticationToken userAuthenticationToken = new UserAuthenticationToken(user);
        boolean isSaved = userAuthTokenService.saveToken(userAuthenticationToken);

        if(isSaved){
            return new SignOutSignInOutput("User signed in successfully",userAuthenticationToken.getAuthToken());
        }else{
            return new SignOutSignInOutput("Cannot sign in user ,please try again later",null);
        }
    }

    public SignOutSignInOutput signOut(String email, String token) {

        if(userAuthTokenService.isAuthenticated(email,token)) {
            userAuthTokenService.deleteToken(token);
            return new SignOutSignInOutput("Signed out succesfully",null);
        }else{
            return new SignOutSignInOutput("Email or token does not matched",token);
        }
    }

    public User getUserByEmail(String email) {
        return iUserRepo.findByEmail(email);
    }

    public boolean deleteBasedOnEmail(String email) {
        if(email != null) {
            User user = iUserRepo.findByEmail(email);
            if(user != null){
                iUserRepo.deleteById(user.getId());
                return true;
            }
        }
        return false;
    }

    public List<User> getAllUsers() {
        return iUserRepo.findAll();
    }
}
