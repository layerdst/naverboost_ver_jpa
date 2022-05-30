package com.reserve.naverboost.domain.category;

import com.reserve.naverboost.domain.product.ProductRepository;
import com.reserve.naverboost.domain.product.ProductService;
import com.reserve.naverboost.entity.Product;
import com.reserve.naverboost.util.exception.CustomException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRespositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Test
    void categoryByIdProduct() throws CustomException {
        System.out.println(productService.categorySearch(1L));
    }
}