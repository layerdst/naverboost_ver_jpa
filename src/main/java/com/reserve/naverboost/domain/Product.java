package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.auditing.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;


    private String content;

    private String description;

    private String event;

    /**
     * product -> img 연관관계 주인 고민해볼것!
     *
     */
//
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages = new ArrayList<>();

//    public void addCategory(Category category){
//        this.category = category;
//        category.getProducts().add(this);
//    }








}

