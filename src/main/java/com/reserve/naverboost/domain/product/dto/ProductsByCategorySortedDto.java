package com.reserve.naverboost.domain.product.dto;

import com.reserve.naverboost.entity.Product;
import com.reserve.naverboost.entity.ProductImage;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductsByCategorySortedDto {


    private Long id;
    private String categoryName;
    private List<Product> products;

    private Long productId;
    private String productContent;
    private String productDescription;
    private String productEvent;
    private ProductImage productImage;



    public ProductsByCategorySortedDto() {

    }


    public ProductsByCategorySortedDto(Long id, String categoryName, List<Product> products, String productContent, String productDescription, String productEvent, ProductImage productImage) {
        this.id = id;
        this.categoryName = categoryName;
        this.products = products;
        this.productContent = productContent;
        this.productDescription = productDescription;
        this.productEvent = productEvent;
        this.productImage = productImage;
    }
}
