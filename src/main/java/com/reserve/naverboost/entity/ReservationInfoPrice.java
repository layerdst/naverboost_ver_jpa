package com.reserve.naverboost.entity;

import com.reserve.naverboost.entity.auditing.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
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

    public ReservationInfoPrice(){

    }

    public void addProductPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
        productPrice.getReservationInfoPrices().add(this);
    }

    public void addReservationInfo(ReservationInfo reservationInfo){
        this.reservationInfo = reservationInfo;
        reservationInfo.getReservationInfoPrices().add(this);
    }

    public ReservationInfoPrice(ReservationInfo reservationInfo, ProductPrice productPrice, int count) {
        this.count = count;
        addReservationInfo(reservationInfo);
        addProductPrice(productPrice);
    }

    public static ReservationInfoPrice createReservationInfoPrice(ReservationInfo reservationInfo, ProductPrice productPrice, int count){
        return new ReservationInfoPrice(reservationInfo, productPrice, count);
    }


}
