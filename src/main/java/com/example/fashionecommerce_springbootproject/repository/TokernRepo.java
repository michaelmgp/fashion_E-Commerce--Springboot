package com.example.fashionecommerce_springbootproject.repository;

import com.example.fashionecommerce_springbootproject.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokernRepo extends JpaRepository<AuthenticationToken, Integer> {
}
