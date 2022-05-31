package com.reserve.naverboost.entity;

import com.reserve.naverboost.entity.auditing.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class ReservationInfoPrice  extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name="reservation_info_price_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="reservation_info_id")
    private ReservationInfo reservationInfo;

    @ManyToOne
    @JoinColumn(name = "product_price_id")
    private ProductPrice productPrice;

    private int count;

}
