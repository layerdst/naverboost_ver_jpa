package com.reserve.naverboost.domain.product;

import com.reserve.naverboost.domain.category.CategoryRespository;
import com.reserve.naverboost.domain.product.dto.ProductsByCategoryQueryDto;
import com.reserve.naverboost.domain.product.dto.ProductsDto;
import com.reserve.naverboost.entity.Category;
import com.reserve.naverboost.entity.Product;
import com.reserve.naverboost.util.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.reserve.naverboost.util.exception.CustomResponseStatus.DB_ERR;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRespository categoryRespository;

    public Product productSave(int categoryId, String content, String description, String event) throws CustomException {

       return null;
    }

    public List<ProductsByCategoryQueryDto> findByCategoryId(Long categoryId){
        return productRepository.findByCategoryId(categoryId);
    }

    public List<ProductsByCategoryQueryDto> findByCategoryAll(){
        return productRepository.findByCategoryAll();
    }

    public Category categorySearch(Long categoryId) throws CustomException{
        return categoryRespository.findById(categoryId)
                .orElseThrow(()->new CustomException(DB_ERR));
    }


    public List<ProductsDto> findDisplayInfoByCategoryId(Long id) {
        return productRepository.findDisplayInfoByCategoryId(id);
    }
}
