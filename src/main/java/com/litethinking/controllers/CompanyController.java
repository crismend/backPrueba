package com.litethinking.controllers;

import com.litethinking.entities.Category;
import com.litethinking.entities.Company;
import com.litethinking.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity save (@RequestBody Company com){
        return new ResponseEntity(companyService.save(com), HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity getEmpresa(@PathVariable(value="id") Long id) {
        return new ResponseEntity(companyService.getById(id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getAll (){
        return new ResponseEntity(companyService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update (@RequestBody Company com){
        return new ResponseEntity(companyService.save(com), HttpStatus.ACCEPTED);
    }
}
