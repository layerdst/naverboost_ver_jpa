package com.reserve.naverboost.domain.reservation.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationInsertResDto {


    public ReservationInsertResDto(Long displayInfoId, Long productId, Long reservationInfoId, String reservationName, String resrvationTel, LocalDateTime reservationDate, String reservationEmail, boolean cancelYn, LocalDateTime createDate, LocalDateTime modifiedDate, List<PricesResDto> prices) {
        this.displayInfoId = displayInfoId;
        this.productId = productId;
        this.reservationInfoId = reservationInfoId;
        this.reservationName = reservationName;
        this.resrvationTel = resrvationTel;
        this.reservationDate = reservationDate;
        this.reservationEmail = reservationEmail;
        this.cancelYn = cancelYn;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.prices = prices;
    }

    public ReservationInsertResDto() {
    }

    private Long displayInfoId;
    private Long productId;
    private Long reservationInfoId;
    private String reservationName;
    private String resrvationTel;
    private LocalDateTime reservationDate;
    private String reservationEmail;

    private boolean cancelYn;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    private List<PricesResDto> prices = new ArrayList();

}
