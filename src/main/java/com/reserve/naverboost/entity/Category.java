package com.reserve.naverboost.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reserve.naverboost.entity.auditing.BaseTimeEntity;
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
public class Category extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String categoryName;

    @JsonBackReference
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    Category(String categoryName){
        this.categoryName = categoryName;
    }

    public static Category createCategory(String categoryName){
        return new Category(categoryName);
    }
}
