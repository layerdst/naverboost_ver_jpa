package com.reserve.naverboost.domain.category.dto;

import lombok.Getter;

@Getter
public class CategoryListDto {

    private Long id;
    private String name;
    private Long count;

    public CategoryListDto(){

    }

    public CategoryListDto(Long id, String name, Long count){
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public static CategoryListDto createCategoryDto(Long id, String name, Long count){
        return new CategoryListDto(id, name, count);
    }
}
