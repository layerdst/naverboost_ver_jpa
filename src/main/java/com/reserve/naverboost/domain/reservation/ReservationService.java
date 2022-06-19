package com.reserve.naverboost.domain.reservation;

import com.reserve.naverboost.domain.displayinfo.DisplayInfoRepository;
import com.reserve.naverboost.domain.product.ProductRepository;
import com.reserve.naverboost.domain.reservation.dto.*;
import com.reserve.naverboost.entity.DisplayInfo;
import com.reserve.naverboost.entity.Product;
import com.reserve.naverboost.entity.ProductPrice;
import com.reserve.naverboost.entity.ReservationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ProductRepository productRepository;
    private final DisplayInfoRepository displayInfoRepository;

    public List<ReservationInfoQueryDto> findByReservationInfo(String email) {
        List<ReservationInfoQueryDto> result = findReservationInfos(email);

        List<Long> displayInfoIds = result.stream()
                .map(v->v.getDisplayId())
                .collect(Collectors.toList());

        List<ReservationDisplayInfoQueryDto> displayInfos = reservationRepository.reservationInQuery(displayInfoIds);

        Map<Long, ReservationDisplayInfoQueryDto> displayMap = displayInfos.stream()
                .collect(Collectors.toMap(x->x.getDisplayId(), x -> x));

        result.forEach(o->o.setDisplayInfoDto(displayMap.get(o.getDisplayId())));
        return result;
    }

    private List<ReservationInfoQueryDto> findReservationInfos(String email) {
        return reservationRepository.findByReservationByEmail(email);
    }


    public ReservationInsertResDto createReservation(ReservationInsertReqDto req) {
        Product pr = productRepository.findById(req.getProductId());
        DisplayInfo di = displayInfoRepository.findById(req.getDisplayInfoId());

        ReservationInfo reservationInfo = reservationRepository.createReservation(pr, di, req.getReservationName(), req.getReservationTel(), req.getReservationEmail(), req.getReservationTime(), true);
        long[] productPriceIds = req.getPrices().stream()
                .mapToLong(v -> v.getProductPriceId())
                .toArray();

        List<ProductPrice> productPrices = productRepository.findProductPrices(productPriceIds);
        
        return null;

    }


}
