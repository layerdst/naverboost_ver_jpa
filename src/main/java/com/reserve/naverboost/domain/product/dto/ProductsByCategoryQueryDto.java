package com.reserve.naverboost.domain.product.dto;

import com.reserve.naverboost.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductsByCategoryQueryDto {

    private Long id;
    private String categoryName;
    private Product products;


    public ProductsByCategoryQueryDto(){

    }

    public ProductsByCategoryQueryDto(Long id, String categoryName, Product products){
        this.id = id;
        this.categoryName = categoryName;
        this.products = products;
    }



}
