package com.example.fashionecommerce_springbootproject.repository;

import com.example.fashionecommerce_springbootproject.domain.model.Design;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignRepo extends JpaRepository<Design, Integer> {
}
