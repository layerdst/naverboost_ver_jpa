package com.reserve.naverboost.domain.category;

import com.reserve.naverboost.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRespository categoryRespository;


    private List<Category> findAllCategory(){
        return categoryRespository.categories();
    }



}
