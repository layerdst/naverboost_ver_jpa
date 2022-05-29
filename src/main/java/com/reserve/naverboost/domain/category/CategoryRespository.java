package com.reserve.naverboost.domain.category;

import com.reserve.naverboost.entity.Category;

import com.reserve.naverboost.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@ToString
@Repository
public class CategoryRespository {

    private final EntityManager em;

    public Category save(String categoryName){
        Category category = Category.createCategory(categoryName);
        em.persist(category);
        return  category;
    }




}
