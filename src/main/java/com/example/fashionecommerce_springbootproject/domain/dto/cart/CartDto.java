package com.example.fashionecommerce_springbootproject.domain.dto.cart;


import java.util.List;

public class CartDto {
    List<CartItemDto> cartItems;
    private Double totalCost;

    public CartDto() {
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
