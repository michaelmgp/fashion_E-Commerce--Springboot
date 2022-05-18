package com.example.fashionecommerce_springbootproject.service;

import com.example.fashionecommerce_springbootproject.domain.dto.cart.AddToCartDto;
import com.example.fashionecommerce_springbootproject.domain.dto.cart.CartDto;
import com.example.fashionecommerce_springbootproject.domain.dto.cart.CartItemDto;
import com.example.fashionecommerce_springbootproject.domain.model.Cart;
import com.example.fashionecommerce_springbootproject.domain.model.Design;
import com.example.fashionecommerce_springbootproject.domain.model.User;
import com.example.fashionecommerce_springbootproject.exeptions.CustomException;
import com.example.fashionecommerce_springbootproject.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    DesignService designService;

    public void addToCart(AddToCartDto addToCartDto, User user) {

        // validate if the product id is valid
        Design design = designService.findById(addToCartDto.getDesignId());
        Cart cart = new Cart();
        cart.setDesign(design);
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());

        // save the cart
        cartRepo.save(cart);
    }

    public CartDto listCartItems(User user) {
        List<Cart> cartList= cartRepo.findAllByUserOrderByCreatedDateDesc(user);

        List<CartItemDto> cartItems = new ArrayList<>();
        double totalCost = 0;

        for(Cart cart : cartList){
            CartItemDto cartItemDto = new CartItemDto(cart);
            totalCost += cartItemDto.getQuantity() * cart.getDesign().getPrice();
            cartItems.add(cartItemDto);
        }
        CartDto cartDto= new CartDto();
        cartDto.setTotalCost(totalCost);
        cartDto.setCartItems(cartItems);
        return cartDto;
    }

    public void deleteCartItem(Integer cartItemId, User user) {

        // check the item id belongs to user
        Optional<Cart> optionalCart = cartRepo.findById(cartItemId);

        if(optionalCart.isEmpty()){
            throw new CustomException("cart item id is invalid: " + cartItemId);
        }
        
        Cart cart = optionalCart.get();

        if (cart.getUser() != user){
            throw new CustomException("cart item does not belong to user: " + cartItemId);
        }

        cartRepo.delete(cart);
    }
}
