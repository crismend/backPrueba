package com.litethinking.repositories;

import com.litethinking.entities.Product;
import com.litethinking.entities.User;
import com.litethinking.models.InventoryModelB;
import com.litethinking.models.ProductModelB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.coding, p.nameprod, p.features, p.category_id FROM products p", nativeQuery = true)
    List<ProductModelB> getAll();

    @Query(value = "SELECT p.coding, p.nameprod, p.features, p.category_id FROM products p WHERE p.coding = ?1", nativeQuery = true)
    ProductModelB getProdById(@Param("coding") Long coding);
}
