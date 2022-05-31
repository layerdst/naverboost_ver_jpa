package com.reserve.naverboost.domain.product;


import com.reserve.naverboost.domain.product.dto.ProductsByCategoryQueryDto;
import com.reserve.naverboost.domain.product.dto.ProductsDto;
import com.reserve.naverboost.entity.Category;
import com.reserve.naverboost.entity.FileInfo;
import com.reserve.naverboost.entity.Product;
import com.reserve.naverboost.entity.ProductImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final EntityManager em;

    public void productSave(Product product) {
        em.persist(product);
    }

    public Product findById(Long id){
        return em.find(Product.class, id);
    }

    public void productImageSave(ProductImage image) {
        em.persist(image);
    }

    public void fileInfoSave(FileInfo fileInfo){
        em.persist(fileInfo);
    }


    public List<ProductsByCategoryQueryDto> findByCategoryId(Long id){
        return em.createQuery("select new com.reserve.naverboost.domain.product.dto.ProductsByCategoryQueryDto" +
                "(c.id, c.categoryName, p)" +
                " from Product p left join p.category c where c.id = :id")
                .setParameter("id", id)
                .getResultList();
    }

    public List<ProductsByCategoryQueryDto> findByCategoryAll(){
        return em.createQuery("select new com.reserve.naverboost.domain.product.dto.ProductsByCategoryQueryDto" +
                "(c.id, c.categoryName, p)" +
                " from Product p left join p.category c ")
                .getResultList();
    }

    public List<Category> findAll(){
        return em.createQuery("select c from Category c join c.products p").getResultList();
    }


    public List<ProductsDto> findDisplayInfoByCategoryId(Long id) {
        return em.createQuery("select new com.reserve.naverboost.domain.product.dto.ProductsDto" +
                "(d.id, d.placeName, p.content, p.description, p.id, fi.saveFileName ) " +
                " from DisplayInfo d " +
                " join d.product p " +
                " join p.category c " +
                " join p.productImages pi " +
                " join pi.fileInfo fi " +
                " where pi.imgType = \'MA\' " +
                " and c.id = :id "
                )
                .setParameter("id", id)
                .getResultList();
    }


}
