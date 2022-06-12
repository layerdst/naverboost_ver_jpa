package com.reserve.naverboost.domain.reservation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
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
    private ReservationDisplayInfoQueryDto displayInfoDto;
    private float totalPrice;



    public ReservationInfoQueryDto(Long id, Long productId, Long displayId, String reservationName, String reservationTelePhone, String reservationEmail, boolean cancelYn, LocalDateTime reservationDate, LocalDateTime createDate, LocalDateTime modifyDate, float totalPrice) {
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
