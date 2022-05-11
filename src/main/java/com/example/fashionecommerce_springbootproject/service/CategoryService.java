package com.example.fashionecommerce_springbootproject.service;

import com.example.fashionecommerce_springbootproject.model.Category;
import com.example.fashionecommerce_springbootproject.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public void createCategory(Category category){
        categoryRepo.save(category);
    }

}
