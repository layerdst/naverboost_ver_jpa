package com.reserve.naverboost.entity;

import com.reserve.naverboost.entity.auditing.BaseTimeEntity;
import com.reserve.naverboost.entity.enums.EnumPriceType;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class ProductPrice extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name="product_price_id")
    private Long id;

    /**
     * product -> price 연관관계 주인 고민
     */
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @OneToMany(mappedBy = "productPrice")
    List<ReservationInfoPrice> reservationInfoPrices = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private EnumPriceType priceTypeName;

    private int price;

    private float discountRate;


    public ProductPrice(){
    }

    public ProductPrice(Product product, EnumPriceType priceTypeName, int price, float discountRate) {
        this.product = product;
        this.priceTypeName = priceTypeName;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static ProductPrice createProductPrice(Product product, EnumPriceType priceTypeName, int price, float discountRate){
        return new ProductPrice(product, priceTypeName, price, discountRate);
    }
}
