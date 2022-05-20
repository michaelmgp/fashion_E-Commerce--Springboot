package com.example.fashionecommerce_springbootproject.repository;

import com.example.fashionecommerce_springbootproject.domain.model.AuthenticationToken;
import com.example.fashionecommerce_springbootproject.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokernRepo extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUser(User user);

    AuthenticationToken findByToken(String token);
}
