package com.example.fashionecommerce_springbootproject.repository;

import com.example.fashionecommerce_springbootproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
