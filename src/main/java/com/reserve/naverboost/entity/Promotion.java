package com.reserve.naverboost.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Promotion {

    @Id
    @GeneratedValue
    @Column(name="promotion_id")
    private Long id;

    
}
