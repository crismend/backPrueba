package com.litethinking.services;

import com.litethinking.entities.Category;
import com.litethinking.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category save (Category cat){
        return categoryRepository.save(cat);
    }

    public List<Category> getAll (){
        return categoryRepository.findAll();
    }
}
