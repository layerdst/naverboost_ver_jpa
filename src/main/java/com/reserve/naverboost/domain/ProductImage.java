package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.enums.EnumImageType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.ImageType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ProductImage {

    @Id
    @GeneratedValue
    @Column(name="product_image_id")
    private Long id;


    /**
     * product -> img 연관관계 주인 고민해볼것!
     *
     */
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Enumerated(value=EnumType.STRING)
    private EnumImageType imgType;

    @ManyToOne
    @JoinColumn(name="file_info_id")
    private FileInfo fileInfo;

    ProductImage createProductImage(EnumImageType imgType, FileInfo fileInfo){

        return null;
    }





    





}
