package com.reserve.naverboost.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class DisplayInfo {

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






}
