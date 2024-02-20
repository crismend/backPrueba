package com.litethinking.controllers;

import com.litethinking.entities.Category;
import com.litethinking.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public ResponseEntity save (@RequestBody Category cat){

        return new ResponseEntity(categoryService.save(cat), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAll (){
        return new ResponseEntity(categoryService.getAll(), HttpStatus.OK);
    }
}
