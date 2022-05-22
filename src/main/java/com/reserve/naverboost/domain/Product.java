package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.auditing.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public void addCategory(Category category){
        this.category = category;
        category.getProducts().add(this);
    }








}

