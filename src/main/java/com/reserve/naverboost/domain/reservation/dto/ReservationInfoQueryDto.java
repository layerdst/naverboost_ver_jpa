package com.reserve.naverboost.domain.reservation.dto;

import lombok.Getter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
public class ReservationInfoQueryDto {

    private Long id;
    private Long productId;
    private Long displayId;
    private String reservationName;
    private String reservationTelePhone;
    private String reservationEmail;
    private boolean cancelYn;
    private LocalDateTime reservationDate;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    private InDisplayInfoQueryDto displayInfoDto;
    private int totalPrice;
    

    @Getter
    private class InDisplayInfoQueryDto {
        private Long productId;
        private Long categoryId;
        private Long displayId;
        private String categoryName;
        private String productDescription;
        private String productContent;
        private String productEvent;
        private String openingHours;
        private String placeLot;
        private String placeStreet;
        private String telephone;
        private String homepage;
        private String email;
        private LocalDateTime createDate;
        private LocalDateTime modifyDate;
    }


    public ReservationInfoQueryDto(Long id, Long productId, Long displayId, String reservationName, String reservationTelePhone, String reservationEmail, boolean cancelYn, LocalDateTime reservationDate, LocalDateTime createDate, LocalDateTime modifyDate, int totalPrice) {
        this.id = id;
        this.productId = productId;
        this.displayId = displayId;
        this.reservationName = reservationName;
        this.reservationTelePhone = reservationTelePhone;
        this.reservationEmail = reservationEmail;
        this.cancelYn = cancelYn;
        this.reservationDate = reservationDate;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.totalPrice = totalPrice;
    }
}
