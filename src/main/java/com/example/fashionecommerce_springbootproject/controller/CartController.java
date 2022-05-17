package com.example.fashionecommerce_springbootproject.controller;

import com.example.fashionecommerce_springbootproject.domain.common.ApiResponse;
import com.example.fashionecommerce_springbootproject.domain.dto.cart.AddToCartDto;
import com.example.fashionecommerce_springbootproject.domain.model.User;
import com.example.fashionecommerce_springbootproject.service.AuthenticationService;
import com.example.fashionecommerce_springbootproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    AuthenticationService authenticationService;


    //post cart api

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token){

        //authenticate the token
        authenticationService.authenticate(token);

        // find the user
        User user = authenticationService.getUser(token);


        cartService.addToCart(addToCartDto,user);

        return new ResponseEntity<>(new ApiResponse(true, "Added To Cart "), HttpStatus.OK);
    }

    //get all cart item for user

    // delete cart item for user

}
