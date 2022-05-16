package com.example.fashionecommerce_springbootproject.service;

import com.example.fashionecommerce_springbootproject.dto.user.ResponseDto;
import com.example.fashionecommerce_springbootproject.dto.user.SigninDto;
import com.example.fashionecommerce_springbootproject.dto.user.SigninResponseDto;
import com.example.fashionecommerce_springbootproject.dto.user.SignupDto;
import com.example.fashionecommerce_springbootproject.exeptions.CustomException;
import com.example.fashionecommerce_springbootproject.model.AuthenticationToken;
import com.example.fashionecommerce_springbootproject.model.User;
import com.example.fashionecommerce_springbootproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;

    @Transactional
    public ResponseDto signUp(SignupDto signupDto) {

        if (Objects.nonNull(userRepo.findByEmail(signupDto.getEmail()))) {
            throw new CustomException("User Already Resgistered");
        }

        String encryptedPassword = signupDto.getPassword();

        try {
            encryptedPassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User user = new User(signupDto.getFirstName(), signupDto.getLastName(),
                signupDto.getEmail(), encryptedPassword);

        userRepo.save(user);

        final AuthenticationToken authenticationToken = new AuthenticationToken(user);

        authenticationService.saveConfirmation(authenticationToken);

        ResponseDto responseDto = new ResponseDto("success", "User Created Succesfully");
        return responseDto;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MDS");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();

        return hash;
    }

    public SigninResponseDto sigIn(SigninDto signinDto) {
        // fin
    }
}
