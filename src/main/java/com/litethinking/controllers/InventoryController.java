package com.litethinking.controllers;

import com.litethinking.entities.Company;
import com.litethinking.entities.Inventory;
import com.litethinking.entities.Product;
import com.litethinking.models.InventoryModel;
import com.litethinking.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity save (@RequestBody InventoryModel inv){
        return new ResponseEntity(inventoryService.save(transInv(inv)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAll (){
        return new ResponseEntity(inventoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity getInventario(@PathVariable(value="id") Long id) {
        return new ResponseEntity(inventoryService.getInvById(id), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity update (@RequestBody InventoryModel inv){
        return new ResponseEntity(inventoryService.save(transInv(inv)), HttpStatus.ACCEPTED);
    }

    private Inventory transInv(InventoryModel inv){
        Inventory inven = new Inventory();
        inven.setId(inv.getId());

        Company comp = new Company();
        comp.setId(inv.getCompanyId());
        inven.setCompanyId(comp);

        inven.setStock(inv.getStock());

        Product pro = new Product();
        pro.setCoding(inv.getProductId());
        inven.setProductId(pro);

        return inven;
    }
}
