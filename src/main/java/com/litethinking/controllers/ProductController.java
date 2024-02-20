package com.litethinking.controllers;

import com.litethinking.entities.Category;
import com.litethinking.entities.Inventory;
import com.litethinking.entities.Product;
import com.litethinking.models.ProductModel;
import com.litethinking.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity save (@RequestBody ProductModel pro){
        return new ResponseEntity(productService.save(transProd(pro)), HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity getProducto(@PathVariable(value="id") Long id) {
        return new ResponseEntity(productService.getProdById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAll (){
        return new ResponseEntity(productService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update (@RequestBody ProductModel pro){
        return new ResponseEntity(productService.save(transProd(pro)), HttpStatus.ACCEPTED);
    }

    private Product transProd(ProductModel pro){
        Product prod = new Product();

        prod.setCoding(pro.getCoding());
        prod.setFeatures(pro.getFeatures());
        prod.setNameprod(pro.getNameprod());

        Category cat = new Category();
        cat.setId(pro.getCategoryId());
        prod.setCategoryId(cat);

        return prod;
    }
}
