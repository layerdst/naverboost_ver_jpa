package com.reserve.naverboost.domain.category;

import com.reserve.naverboost.domain.product.ProductRepository;
import com.reserve.naverboost.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRespositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void categoryByIdProduct() {
        System.out.println(productRepository.findByCategoryId(1L));
    }
}