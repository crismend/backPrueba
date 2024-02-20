package com.litethinking.models;

import lombok.Data;

@Data
public class InventoryModel {
    private Long id;
    private Long companyId;
    private Long productId;
    private Long stock;
}
