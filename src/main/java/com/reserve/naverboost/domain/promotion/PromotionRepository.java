package com.reserve.naverboost.domain.promotion;

import com.reserve.naverboost.domain.promotion.dto.PromotionQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;



@Repository
@RequiredArgsConstructor
public class PromotionRepository {

    private final EntityManager em;

    public List<PromotionQueryDto> findPromotions(){
        return em.createQuery("select new com.reserve.naverboost.domain.promotion.dto.PromotionQueryDto(pr.id ,p.id, fi.saveFileName) " +
                "from Promotion pr " +
                "join pr.product p " +
                "join p.productImages pi " +
                "join pi.fileInfo fi "+
                " where pi.imgType= \'MA\' " ).getResultList();
    }

}
