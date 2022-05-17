package com.example.fashionecommerce_springbootproject.repository;

import com.example.fashionecommerce_springbootproject.domain.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
