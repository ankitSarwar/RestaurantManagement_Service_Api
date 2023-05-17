package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.dto.SignInInput;
import com.example.Restaurant.management.service.API.dto.SignInOutput;
import com.example.Restaurant.management.service.API.dto.SignUpInput;
import com.example.Restaurant.management.service.API.dto.SignUpOutput;
import com.example.Restaurant.management.service.API.model.AuthenticationToken;
import com.example.Restaurant.management.service.API.model.User;
import com.example.Restaurant.management.service.API.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    TokenService tokenService;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found with id: " + id));
    }




    public SignUpOutput signup(SignUpInput signUpInput) {
        User user=userRepository.findFirstByuserContact(signUpInput.getUserContact());

        if(user!=null){
            throw new IllegalStateException("user already exists!!!!!.......sign in instead ");
        }

        String encryptedPassword=null;
        try{
            encryptedPassword=encryptedPassword(signUpInput.getPassword());
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        user=new User(signUpInput.getUsername(),encryptedPassword,signUpInput.getEmail(),
                signUpInput.getAddress(),signUpInput.getUserContact());
        userRepository.save(user);

        AuthenticationToken token=new AuthenticationToken(user);

        tokenService.saveToken(token);

        return new SignUpOutput("user Register Successfully",token.getToken());

    }

    private String encryptedPassword(String userPassword) throws NoSuchAlgorithmException{
        MessageDigest md5=MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested =  md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }



    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setAddress(updatedUser.getAddress());
        user.setUserContact(updatedUser.getUserContact());
        return userRepository.save(user);
    }


    public SignInOutput signIn(SignInInput signInInput) {

        User user=userRepository.findFirstByuserContact(signInInput.getUserContact());
        if(user==null){
            throw new IllegalStateException("user Not  exists!!!!!.......sign up instead ");
        }

        String encryptedPassword=null;
        try{
            encryptedPassword=encryptedPassword(signInInput.getUserPassword());
        }catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        boolean isPasswordValid=encryptedPassword.equals(user.getPassword());

        if(!isPasswordValid){
                throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token=tokenService.getToken(user);

        return new SignInOutput("Authentication Successfull !!!",token.getToken());
    }



    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public List<User> AllUser() {

        return userRepository.findAll();
    }
}

