package com.reserve.naverboost.domain.category;

import com.reserve.naverboost.domain.category.dto.CategoryListDto;
import com.reserve.naverboost.util.exception.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public CustomResponse<List<CategoryListDto>> getCategoryLists(){
        List<CategoryListDto> categoryListDtos = categoryService.categoryLists();
        return new CustomResponse<>(categoryListDtos);
    }
}
