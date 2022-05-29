package com.reserve.naverboost.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category{

    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    Category(String categoryName){
        this.categoryName = categoryName;
    }

    public static Category createCategory(String categoryName){
        return new Category(categoryName);
    }
}
