package com.example.fashionecommerce_springbootproject.domain.dto.cart;

import com.example.fashionecommerce_springbootproject.domain.model.Cart;
import com.example.fashionecommerce_springbootproject.domain.model.Design;

public class CartItemDto {
    private Integer id;
    private Integer quantity;
    private Design design;

    public CartItemDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Design getDesign() {
        return design;
    }

    public void setDesign(Design design) {
        this.design = design;
    }

    public CartItemDto(Cart cart) {
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.setDesign(cart.getDesign());

    }
}
