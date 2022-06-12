package com.reserve.naverboost.domain.reservation;

import com.reserve.naverboost.domain.reservation.dto.ReservationInfoQueryDto;
import com.reserve.naverboost.util.exception.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/")
    public CustomResponse<List<ReservationInfoQueryDto>> findbyEmail(
            @RequestParam String email) {
        List<ReservationInfoQueryDto> byReservationInfo = reservationService.findByReservationInfo(email);
        return new CustomResponse<>(byReservationInfo);
    }

}
