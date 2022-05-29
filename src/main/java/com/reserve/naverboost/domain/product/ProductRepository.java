package com.reserve.naverboost.domain.product;


import com.reserve.naverboost.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final EntityManager em;

    public void save(Product product) {
        em.persist(product);
    }

    public Product findById(Long id){
        return em.find(Product.class, id);
    }

    public List<Product> findByCategoryId(Long id){
        return em.createQuery("select p from Product p join p.category c where c.id = :id")
                .setParameter("id", id)
                .getResultList();
    }
    


}
