package com.example.fashionecommerce_springbootproject.controller;

import com.example.fashionecommerce_springbootproject.domain.common.ApiResponse;
import com.example.fashionecommerce_springbootproject.domain.dto.cart.AddToCartDto;
import com.example.fashionecommerce_springbootproject.domain.dto.cart.CartDto;
import com.example.fashionecommerce_springbootproject.domain.model.User;
import com.example.fashionecommerce_springbootproject.service.AuthenticationService;
import com.example.fashionecommerce_springbootproject.service.CartService;
import io.swagger.models.auth.In;
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

        return new ResponseEntity<>(new ApiResponse(true, "Added To Cart "), HttpStatus.CREATED);
    }

    //get all cart item for user
    @GetMapping("/")
    public ResponseEntity <CartDto> getCartItems(@RequestParam("token") String token ){
        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }


    // delete cart item for user
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId")Integer itemId,
                                                      @RequestParam("token") String token){
        authenticationService.authenticate(token);

        // find the user
        User user = authenticationService.getUser(token);

        cartService.deleteCartItem(itemId,user);

        return new ResponseEntity<>(new ApiResponse(true, "Item Has Been Removed "), HttpStatus.OK);
    }
}
