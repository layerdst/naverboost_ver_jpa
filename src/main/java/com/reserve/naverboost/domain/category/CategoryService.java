package com.reserve.naverboost.domain.category;

import com.reserve.naverboost.domain.category.dto.CategoryListDto;
import com.reserve.naverboost.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRespository categoryRespository;

    public List<Category> findAllCategory(){
        return categoryRespository.categories();
    }

    public List<CategoryListDto> categoryLists(){
        return categoryRespository.categoryList();
    }


}
