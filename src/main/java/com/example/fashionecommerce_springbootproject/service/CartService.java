package com.example.fashionecommerce_springbootproject.service;

import com.example.fashionecommerce_springbootproject.domain.dto.cart.AddToCartDto;
import com.example.fashionecommerce_springbootproject.domain.model.Design;
import com.example.fashionecommerce_springbootproject.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    DesignService designService;

    public void addToCart(AddToCartDto addToCartDto, User user) {

        // validate if the product id is valid
        Design design = designService.findById(addToCartDto.getDesignId());
        // save the cart
    }
}
