package com.reserve.naverboost.domain;

import javax.persistence.*;

@Entity
public class ReservationUserComment {

    @Id
    @GeneratedValue
    @Column(name="reservation_user_comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="reservation_info_id")
    private ReservationInfo reservationInfo;

    private float score;

    private String comment;



}
