package com.litethinking.models;

import lombok.Data;


public interface InventoryModelB {
    Long getId();
    String getNameprod();
    String getNamecomp();
    Long getStock();

    Long getProduct_id();

    Long getCompany_id();

}
