package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.auditing.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class ReservationInfo extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name="reservation_info_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="display_info_id")
    private DisplayInfo displayInfo;


    @Column(name="reservation_name")
    private String reservationName;

    @Column(name="reservation_tel")
    private String reservationTel;

    @Column(name="reservation_email")
    private String reservationEmail;

    @Column(name="reservation_date")
    private String reservationDate;

    @Column(name="cancel_flag")
    private boolean cancelFlag;






}
