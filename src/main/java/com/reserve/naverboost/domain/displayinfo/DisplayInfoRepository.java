package com.reserve.naverboost.domain.displayinfo;

import com.reserve.naverboost.entity.DisplayInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DisplayInfoRepository {

    private final EntityManager em;


    public DisplayInfo findById(Long id){
        return em.find(DisplayInfo.class, id);
    }
}
