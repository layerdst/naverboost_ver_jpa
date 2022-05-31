package com.reserve.naverboost.domain.product.dto;


import lombok.Getter;

@Getter
public class ProductsDto {

    private Long displayInfoId;
    private String placeName;
    private String productContent;
    private String productDescription;

    private Long productId;
    private String productImageUrl;

    ProductsDto(){

    }

    public ProductsDto(Long displayInfoId, String placeName, String productContent, String productDescription, Long productId, String productImageUrl) {
        this.displayInfoId = displayInfoId;
        this.placeName = placeName;
        this.productContent = productContent;
        this.productDescription = productDescription;
        this.productId = productId;
        this.productImageUrl = productImageUrl;
    }


}
