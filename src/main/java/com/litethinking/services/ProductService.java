package com.litethinking.services;

import com.litethinking.entities.Company;
import com.litethinking.entities.Product;
import com.litethinking.entities.User;
import com.litethinking.models.ProductModelB;
import com.litethinking.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<ProductModelB> getAll(){
        return productRepository.getAll();
    }

    public Product save(Product pro){
        return productRepository.save(pro);
    }


    public ProductModelB getProdById(Long id){
        return productRepository.getProdById(id);
    }
}
