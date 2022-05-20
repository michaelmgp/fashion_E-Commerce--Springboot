package com.example.fashionecommerce_springbootproject.service;


import com.example.fashionecommerce_springbootproject.domain.dto.DesignDto;
import com.example.fashionecommerce_springbootproject.exeptions.DesignNotExistsException;
import com.example.fashionecommerce_springbootproject.domain.model.Category;
import com.example.fashionecommerce_springbootproject.domain.model.Design;
import com.example.fashionecommerce_springbootproject.repository.DesignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DesignService {
    @Autowired
    DesignRepo designRepo;

    public void addDesign(DesignDto designDto, Category category) {
        Design design = new Design();
        design.setDescription(designDto.getDescription());
        design.setImageURL(designDto.getImageURL());
        design.setName(designDto.getName());
        design.setCategory(category);
        design.setPrice(designDto.getPrice());
        designRepo.save(design);
    }

    public DesignDto getdesignDto(Design design){
        DesignDto designDto = new DesignDto();
        designDto.setDescription(design.getDescription());
        designDto.setImageURL(design.getImageURL());
        designDto.setName(design.getName());
        designDto.setCategoryId(design.getCategory().getId());
        designDto.setPrice(design.getPrice());
        designDto.setId(design.getId());
        return designDto;

    }
    public List<DesignDto> getAllDesigns() {

        List<Design> allDesigns = designRepo.findAll();

        List<DesignDto> designDtos = new ArrayList<>();
        for(Design design: allDesigns){
            designDtos.add(getdesignDto(design));

        }
        return designDtos;
    }

    public void updateProduct(DesignDto designDto, Integer designId) throws Exception {
        Optional<Design> optionalDesign = designRepo.findById(designId);
        if(!optionalDesign.isPresent()){
            throw new Exception("design not present");
        }

        Design design = optionalDesign.get();
        design.setDescription(designDto.getDescription());
        design.setImageURL(designDto.getImageURL());
        design.setName(designDto.getName());
        design.setPrice(designDto.getPrice());
        designRepo.save(design);
    }

    public Design findById(Integer designId) throws DesignNotExistsException {

        Optional<Design> optionalDesign = designRepo.findById(designId);
                if(optionalDesign.isEmpty()){
                    throw new DesignNotExistsException("Product id is not valid " + designId );
                }

                return optionalDesign.get();
    }
}
