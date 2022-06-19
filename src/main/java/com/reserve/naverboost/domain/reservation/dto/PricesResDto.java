package com.reserve.naverboost.domain.reservation.dto;

public class PricesResDto {
    private Long reservationInfoId;
    private Long reservationInfoPriceId;
    private Long productPriceId;
    private int count;

    public PricesResDto(Long reservationInfoId, Long reservationInfoPriceId, Long productPriceId, int count) {
        this.reservationInfoId = reservationInfoId;
        this.reservationInfoPriceId = reservationInfoPriceId;
        this.productPriceId = productPriceId;
        this.count = count;
    }

    public Long getReservationInfoId() {
        return reservationInfoId;
    }

    public Long getReservationInfoPriceId() {
        return reservationInfoPriceId;
    }

    public Long getProductPriceId() {
        return productPriceId;
    }

    public int getCount() {
        return count;
    }
}
