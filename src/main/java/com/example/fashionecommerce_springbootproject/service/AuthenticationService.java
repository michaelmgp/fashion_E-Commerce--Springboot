package com.example.fashionecommerce_springbootproject.service;

import com.example.fashionecommerce_springbootproject.exeptions.AuthenticationFailException;
import com.example.fashionecommerce_springbootproject.model.AuthenticationToken;
import com.example.fashionecommerce_springbootproject.model.User;
import com.example.fashionecommerce_springbootproject.repository.TokernRepo;
import com.example.fashionecommerce_springbootproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {
    @Autowired
    TokernRepo tokernRepo;

    public void saveConfirmation(AuthenticationToken authenticationToken) {
        tokernRepo.save(authenticationToken);

    }

    public AuthenticationToken getToken(User user) {
        return tokernRepo.findByUser(user);
    }

    public void authenticate (String token ) throws AuthenticationFailException{

        // null check
        if(Objects.isNull(token)){
            // throw exception
            throw new AuthenticationFailException("token is not present");
        }

        if(Objects.isNull(getUser(token))){
            throw new AuthenticationFailException("token is not valid");
        }
    }

    public User getUser(String token){
       final AuthenticationToken authenticationToken = tokernRepo.findByToken(token);
       if (Objects.isNull(token)){
            return null;
       }

       // authentication is not null
        return authenticationToken.getUser();
    }
}
