package com.reserve.naverboost.domain.reservation.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReservationDisplayInfoQueryDto {

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

    ReservationDisplayInfoQueryDto(){

    }

    public ReservationDisplayInfoQueryDto(Long productId, Long categoryId, Long displayId, String categoryName, String productDescription, String productContent, String productEvent, String openingHours, String placeLot, String placeStreet, String telephone, String homepage, String email, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.displayId = displayId;
        this.categoryName = categoryName;
        this.productDescription = productDescription;
        this.productContent = productContent;
        this.productEvent = productEvent;
        this.openingHours = openingHours;
        this.placeLot = placeLot;
        this.placeStreet = placeStreet;
        this.telephone = telephone;
        this.homepage = homepage;
        this.email = email;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
