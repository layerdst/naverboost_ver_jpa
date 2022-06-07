package com.reserve.naverboost.entity;

import com.reserve.naverboost.entity.auditing.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
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

    @OneToMany(mappedBy = "reservationInfo")
    private List<ReservationInfoPrice> reservationInfoPrices = new ArrayList<>();

    @Column(name="reservation_name")
    private String reservationName;

    @Column(name="reservation_tel")
    private String reservationTel;

    @Column(name="reservation_email")
    private String reservationEmail;

    @Column(name="reservation_date")
    private LocalDateTime reservationDate;

    @Column(name="cancel_flag")
    private boolean cancelFlag;

    public int totalPrice(){
        return reservationInfoPrices.stream()
                .mapToInt(n -> (int)(n.getProductPrice().getPrice() * (1 - n.getProductPrice().getDiscountRate()))).sum();
    }

    public ReservationInfo(){
    }

    public ReservationInfo(Product product, DisplayInfo displayInfo, String reservationName, String reservationTel, String reservationEmail, LocalDateTime reservationDate, boolean cancelFlag) {
        this.product = product;
        this.displayInfo = displayInfo;
        this.reservationName = reservationName;
        this.reservationTel = reservationTel;
        this.reservationEmail = reservationEmail;
        this.reservationDate = reservationDate;
        this.cancelFlag = cancelFlag;
    }

    public static ReservationInfo createReservationInfo(Product product, DisplayInfo displayInfo, String reservationName, String reservationTel, String reservationEmail, LocalDateTime reservationDate, boolean cancelFlag){
        return new ReservationInfo(product, displayInfo, reservationName, reservationTel, reservationEmail, reservationDate, cancelFlag);
    }

}
