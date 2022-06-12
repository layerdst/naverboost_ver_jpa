package com.reserve.naverboost.domain.reservation;

import com.reserve.naverboost.domain.reservation.dto.ReservationDisplayInfoQueryDto;
import com.reserve.naverboost.domain.reservation.dto.ReservationInfoQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<ReservationInfoQueryDto> findByReservationInfo(String email) {
        List<ReservationInfoQueryDto> result = findReservationInfos(email);

        List<Long> displayInfoIds = result.stream().map(v->v.getDisplayId()).collect(Collectors.toList());
        List<ReservationDisplayInfoQueryDto> displayInfos = reservationRepository.reservationInQuery(displayInfoIds);

        Map<Long, ReservationDisplayInfoQueryDto> displayMap = displayInfos.stream().collect(Collectors.toMap(x->x.getDisplayId(), x -> x));

        result.forEach(o->o.setDisplayInfoDto(displayMap.get(o.getDisplayId())));
        return result;
    }

    private List<ReservationInfoQueryDto> findReservationInfos(String email) {
        return reservationRepository.findByReservationByEmail(email);
    }

}
