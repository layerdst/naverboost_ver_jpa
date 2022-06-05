package com.reserve.naverboost.domain.promotion;

import com.reserve.naverboost.domain.promotion.dto.PromotionQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {

    private final PromotionRepository promotionRepository;

    public List<PromotionQueryDto> getPromotions(){
        return promotionRepository.findPromotions();
    }
}
