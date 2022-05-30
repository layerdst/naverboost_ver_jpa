package com.reserve.naverboost.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reserve.naverboost.entity.auditing.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;


    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;


    private String content;

    private String description;

    private String event;

    public Product(Category category, String content, String description, String event){
        this.content = content;
        this.description = description;
        this.event = event;

        addCategory(category);
    }

    /**
     * product -> img 연관관계 주인 고민해볼것!
     *
     */
//
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> productImages = new ArrayList<>();

    public void addCategory(Category category){
        this.category = category;
        category.getProducts().add(this);
    }

    public static Product createProduct(Category category, String content, String description, String event){
        return new Product(category, content, description, event);
    }








}

