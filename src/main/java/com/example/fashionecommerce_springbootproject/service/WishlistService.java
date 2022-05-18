package com.example.fashionecommerce_springbootproject.service;


import com.example.fashionecommerce_springbootproject.domain.dto.DesignDto;
import com.example.fashionecommerce_springbootproject.domain.model.User;
import com.example.fashionecommerce_springbootproject.domain.model.Wishlist;
import com.example.fashionecommerce_springbootproject.repository.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {

    @Autowired
    WishlistRepo wishlistRepo;



    @Autowired
    DesignService designService;

    public void createWishlist(Wishlist wishlist) {
        wishlistRepo.save(wishlist);
    }

    public List<DesignDto> getWishlistForUser(User user) {
        final List<Wishlist> wishlists = wishlistRepo.findAllByUserOrderByCreatedDateDesc(user);
        List<DesignDto> designDtos = new ArrayList<>();

        for (Wishlist wishlist : wishlists){
            designDtos.add(designService.getdesignDto(wishlist.getDesign()));
        }

        return designDtos;
    }
}
