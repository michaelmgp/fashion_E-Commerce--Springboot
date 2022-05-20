package com.example.fashionecommerce_springbootproject.repository;

import com.example.fashionecommerce_springbootproject.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
