package com.litethinking.services;

import com.litethinking.entities.Company;
import com.litethinking.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    public Company save(Company com){
        return companyRepository.save(com);
    }

    public Company getById(Long id){
       return companyRepository.findById(id).get();
    }
}
