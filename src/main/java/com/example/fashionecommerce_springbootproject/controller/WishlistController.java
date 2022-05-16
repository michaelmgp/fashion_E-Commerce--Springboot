package com.example.fashionecommerce_springbootproject.controller;

import com.example.fashionecommerce_springbootproject.common.ApiResponse;
import com.example.fashionecommerce_springbootproject.dto.DesignDto;
import com.example.fashionecommerce_springbootproject.model.Design;
import com.example.fashionecommerce_springbootproject.model.User;
import com.example.fashionecommerce_springbootproject.model.Wishlist;
import com.example.fashionecommerce_springbootproject.service.AuthenticationService;
import com.example.fashionecommerce_springbootproject.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wishlist")
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    @Autowired
    AuthenticationService authenticationService;


    // save product as wishlist item
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToWishlist(@RequestBody Design design, @RequestParam("token") String token){

        // Authenticate the tokern
        authenticationService.authenticate(token);

        // find the user
        User user = authenticationService.getUser(token);
        // Save the Item in Wishlist
        Wishlist wishlist = new Wishlist(user, design);

        wishlistService.createWishlist(wishlist);

        ApiResponse apiResponse = new ApiResponse(true, "Added to Wishlist");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED );

    }


    // get all the wishlist item for user
    @GetMapping("/{token}")
    public ResponseEntity<List<DesignDto>> getWishlist(@PathVariable("token") String token ){
        authenticationService.authenticate(token);

        // find the user
        User user = authenticationService.getUser(token);
        // Save the Item in Wishlist

        List<DesignDto> designDtos = wishlistService.getWishlistForUser(user);

        return new ResponseEntity<>(designDtos, HttpStatus.OK);
    }
}
