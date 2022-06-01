package com.reserve.naverboost.domain.category.dto;

import lombok.Getter;

@Getter
public class CategoryQueryDto {

    private Long id;
    private String name;
    private int count;

    public CategoryQueryDto(){

    }

    public CategoryQueryDto(Long id, String name, int count){
        this.id = id;
        this.name = name;
        this.count = count;
    }

}
