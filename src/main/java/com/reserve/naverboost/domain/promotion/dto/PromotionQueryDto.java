package com.reserve.naverboost.domain.promotion.dto;

import lombok.Getter;

@Getter
public class PromotionQueryDto {

    private Long id;
    private Long productId;
    private String productImageUrl;

    PromotionQueryDto(){

    }

    public PromotionQueryDto(Long id, Long productId, String productImageUrl) {
        this.id = id;
        this.productId = productId;
        this.productImageUrl = productImageUrl;
    }
}
