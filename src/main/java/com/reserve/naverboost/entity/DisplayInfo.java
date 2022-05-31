package com.reserve.naverboost.entity;

import com.reserve.naverboost.entity.auditing.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
public class DisplayInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name="display_info_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="opening_hours")
    private String openingHours;

    @Column(name="place_name")
    private String placeName;

    @Column(name="place_lot")
    private String placeLot;

    @Column(name="place_street")
    private String placeStreet;

    @Column(name="tel")
    private String tel;

    private String homepage;

    private String email;


    DisplayInfo(){

    }

    public DisplayInfo(Product product, String openingHours, String placeName, String placeLot, String placeStreet, String tel, String homepage, String email) {
        this.product = product;
        this.openingHours = openingHours;
        this.placeName = placeName;
        this.placeLot = placeLot;
        this.placeStreet = placeStreet;
        this.tel = tel;
        this.homepage = homepage;
        this.email = email;
    }
}
