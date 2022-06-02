package com.reserve.naverboost.domain.category;

import com.reserve.naverboost.domain.category.dto.CategoryListDto;
import com.reserve.naverboost.entity.Category;

import com.reserve.naverboost.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@ToString
@Repository
public class CategoryRespository {

    private final EntityManager em;

    public void save(String categoryName){
        em.persist(Category.createCategory(categoryName));
    }

    public Optional<Category> findById(Long id){
        return Optional.ofNullable(em.find(Category.class, id));
    }

    public List<Category> categories(){
        return em.createQuery("select c from Category c").getResultList();
    }

    public List<CategoryListDto> categoryList(){
        return em.createQuery("select new com.reserve.naverboost.domain.category.dto.CategoryListDto(c.id, c.categoryName, count(d))" +
                " from Category c " +
                " join c.products p " +
                " join p.displayInfos d " +
                " group by c.id ").getResultList();
    }






}
