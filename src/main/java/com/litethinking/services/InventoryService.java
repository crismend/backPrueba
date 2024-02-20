package com.litethinking.services;

import com.litethinking.entities.Company;
import com.litethinking.entities.Inventory;
import com.litethinking.models.InventoryModelB;
import com.litethinking.models.ProductModelB;
import com.litethinking.repositories.CompanyRepository;
import com.litethinking.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
        public List<InventoryModelB> getAll(){
            //return inventoryRepository.findAll();
            return inventoryRepository.inventory();
        }

        public Inventory save(Inventory inv){
            return inventoryRepository.save(inv);
        }

        public Inventory getById(Long id){
            return inventoryRepository.getById(id);
        }

    public InventoryModelB getInvById(Long id){
        return inventoryRepository.getInvById(id);
    }
}
