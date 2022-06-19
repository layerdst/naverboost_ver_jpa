package com.reserve.naverboost.domain.reservation.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationInsertReqDto {
    private Long displayInfoId;
    private Long productId;
    private String reservationEmail;
    private String reservationName;
    private String reservationTel;
    private LocalDateTime reservationTime;
    private List<PricesResDto> prices;

    public ReservationInsertReqDto(Long displayInfoId, Long productId, String reservationEmail, String reservationName, String reservationTel, List<PricesResDto> prices) {
        this.displayInfoId = displayInfoId;
        this.productId = productId;
        this.reservationEmail = reservationEmail;
        this.reservationName = reservationName;
        this.reservationTel = reservationTel;
        this.reservationTime = LocalDateTime.now();
        this.prices = prices;
    }

    public List<PricesResDto> getPrices() {
        return prices;
    }

    public Long getDisplayInfoId() {
        return displayInfoId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public String getReservationName() {
        return reservationName;
    }

    public String getReservationTel() {
        return reservationTel;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

}
