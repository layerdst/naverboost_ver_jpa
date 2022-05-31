package com.reserve.naverboost.entity;

import com.reserve.naverboost.entity.auditing.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Promotion  extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name="promotion_id")
    private Long id;

    
}
