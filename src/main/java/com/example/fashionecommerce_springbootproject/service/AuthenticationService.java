package com.example.fashionecommerce_springbootproject.service;

import com.example.fashionecommerce_springbootproject.model.AuthenticationToken;
import com.example.fashionecommerce_springbootproject.model.User;
import com.example.fashionecommerce_springbootproject.repository.TokernRepo;
import com.example.fashionecommerce_springbootproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
}
