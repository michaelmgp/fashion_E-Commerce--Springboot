package com.example.fashionecommerce_springbootproject.domain.dto.cart;

import javax.validation.constraints.NotNull;

public class AddToCartDto {

    private Integer id;
    private @NotNull Integer designId;
    private @NotNull Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDesignId() {
        return designId;
    }

    public void setDesignId(Integer designId) {
        this.designId = designId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AddToCartDto() {
    }
}
