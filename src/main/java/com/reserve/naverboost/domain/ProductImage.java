package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.enums.EnumImageType;
import org.hibernate.type.ImageType;

import javax.persistence.*;

@Entity
public class ProductImage {

    @Id
    @GeneratedValue
    @Column(name="product_image_id")
    private Long id;


    /**
     * product -> img 연관관계 주인 고민해볼것!
     *
     */
//    @ManyToOne(mappedBy = "product")
//    private Product product;

    @Enumerated(value=EnumType.STRING)
    private EnumImageType imgType;




}
