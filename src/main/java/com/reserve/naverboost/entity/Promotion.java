package com.reserve.naverboost.entity;

import com.reserve.naverboost.entity.auditing.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Promotion extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name="promotion_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Promotion(){

    }

    public Promotion(Product product){
        this.product = product;
    }

    public static Promotion createPromotion(Product product){
        return new Promotion(product);
    }



}
