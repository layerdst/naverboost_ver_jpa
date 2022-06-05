package com.reserve.naverboost.domain.promotion;

import com.reserve.naverboost.domain.promotion.dto.PromotionQueryDto;
import com.reserve.naverboost.entity.Promotion;
import com.reserve.naverboost.util.exception.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionService promotionService;

    @GetMapping("/")
    public CustomResponse<List<PromotionQueryDto>> getPromotions(){
        List<PromotionQueryDto> promotions = promotionService.getPromotions();
        return new CustomResponse<>(promotions);
    }


}
