package com.example.fashionecommerce_springbootproject.repository;

import com.example.fashionecommerce_springbootproject.model.User;
import com.example.fashionecommerce_springbootproject.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface WishlistRepo extends JpaRepository <Wishlist, Integer> {

    List<Wishlist> findAllByUserOrderByCreatedDateDesc(User user);
}
