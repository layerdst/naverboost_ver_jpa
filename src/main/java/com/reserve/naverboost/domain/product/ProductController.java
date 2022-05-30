package com.reserve.naverboost.domain.product;

import com.reserve.naverboost.domain.product.dto.ProductsByCategoryQueryDto;
import com.reserve.naverboost.util.exception.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public CustomResponse<List<ProductsByCategoryQueryDto>> 전체상품(){
        List<ProductsByCategoryQueryDto> products = productService.findByCategoryAll();
        return new CustomResponse<>(products);
    }

    @GetMapping("category/{id}")
    public CustomResponse<List<ProductsByCategoryQueryDto>> 카테고리별상품(@PathVariable(value = "id") Long id){
        List<ProductsByCategoryQueryDto> products = productService.findByCategoryId(id);
        return new CustomResponse<>(products);
    }



}
