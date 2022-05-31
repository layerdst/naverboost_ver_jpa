package com.reserve.naverboost.domain.product;

import com.reserve.naverboost.domain.product.dto.ProductsByCategoryQueryDto;
import com.reserve.naverboost.domain.product.dto.ProductsDto;
import com.reserve.naverboost.util.exception.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/category/{id}")
    public CustomResponse<List<ProductsByCategoryQueryDto>> 카테고리별상품(@PathVariable(value = "id") Long id){
        List<ProductsByCategoryQueryDto> products = productService.findByCategoryId(id);
        return new CustomResponse<>(products);
    }

    @GetMapping("/")
    public CustomResponse<List<ProductsDto>> 카테고리별전시상품(@Param(value = "categoryId") Long id ){
        List<ProductsDto> products = productService.findDisplayInfoByCategoryId(id);
        return new CustomResponse<>(products);
    }



}
