package com.example.fashionecommerce_springbootproject.repository;

import com.example.fashionecommerce_springbootproject.domain.model.Cart;
import com.example.fashionecommerce_springbootproject.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
