package com.example.fashionecommerce_springbootproject.controller;


import com.example.fashionecommerce_springbootproject.common.ApiResponse;
import com.example.fashionecommerce_springbootproject.dto.DesignDto;
import com.example.fashionecommerce_springbootproject.model.Category;
import com.example.fashionecommerce_springbootproject.model.Design;
import com.example.fashionecommerce_springbootproject.repository.CategoryRepo;
import com.example.fashionecommerce_springbootproject.repository.DesignRepo;
import com.example.fashionecommerce_springbootproject.service.CategoryService;
import com.example.fashionecommerce_springbootproject.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("design")
public class DesignController {
    @Autowired
    DesignService designService;

    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addDesign(@RequestBody DesignDto designDto){
        Optional<Category> optionalCategory = categoryRepo.findById(designDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.BAD_REQUEST);
        }

        designService.addDesign(designDto, optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true,"product has been added"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<DesignDto>> getDesigns(){
        List<DesignDto> designs = designService.getAllDesigns();
        return new ResponseEntity<>(designs,HttpStatus.OK);
    }
    @PostMapping("update/{designId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("designId") Integer designId, @RequestBody DesignDto designDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepo.findById(designDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.BAD_REQUEST);
        }

        designService.updateProduct(designDto, designId);
        return new ResponseEntity<>(new ApiResponse(true, "design has been updated"), HttpStatus.CREATED);
    }
}
