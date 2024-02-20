package com.litethinking.models;

import lombok.Data;

@Data
public class ProductModel {
    private Long coding;
    private String nameprod;
    private String features;
    private Long categoryId;
}
