package com.example.fashionecommerce_springbootproject.controller;


import com.example.fashionecommerce_springbootproject.domain.dto.user.ResponseDto;
import com.example.fashionecommerce_springbootproject.domain.dto.user.SigninDto;
import com.example.fashionecommerce_springbootproject.domain.dto.user.SigninResponseDto;
import com.example.fashionecommerce_springbootproject.domain.dto.user.SignupDto;
import com.example.fashionecommerce_springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class    UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto){
        return userService.signUp(signupDto);

    }

    @PostMapping("/signin")
    public SigninResponseDto signIn(@RequestBody SigninDto signinDto){
        return userService.sigIn(signinDto);
    }

}
