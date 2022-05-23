package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.enums.EnumPriceType;

import javax.persistence.*;

@Entity
public class ProductPrice {

    @Id
    @GeneratedValue
    @Column(name="product_price_id")
    private Long id;

    /**
     * product -> price 연관관계 주인 고민
     */
//    private Product product;

    @Enumerated
    private EnumPriceType priceTypeName;

    private int price;

    private float discountRate;






}
