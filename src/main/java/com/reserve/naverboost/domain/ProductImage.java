package com.reserve.naverboost.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductImage {

    @Id
    @GeneratedValue
    @Column(name="product_image_id")
    private Long id;

    private enum Type type;

}
