package com.litethinking.repositories;

import com.litethinking.entities.Inventory;
import com.litethinking.entities.User;
import com.litethinking.models.InventoryModelB;
import com.litethinking.models.ProductModelB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query(value = "SELECT i.id, p.nameprod, c.namecomp, i.stock, i.product_id, i.company_id  FROM inventory i inner join products p on p.coding = i.product_id inner join companies c on c.id = i.company_id", nativeQuery = true)
    List<InventoryModelB> inventory();

    @Query(value = "SELECT i.id, p.nameprod, c.namecomp, i.stock, i.product_id, i.company_id  FROM inventory i inner join products p on p.coding = i.product_id inner join companies c on c.id = i.company_id AND i.id = ?1", nativeQuery = true)
    InventoryModelB getInvById(@Param("id") Long id);

}
