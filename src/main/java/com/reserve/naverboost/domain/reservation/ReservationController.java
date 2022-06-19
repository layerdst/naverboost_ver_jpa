package com.reserve.naverboost.domain.reservation;

import com.reserve.naverboost.domain.reservation.dto.ReservationInfoQueryDto;
import com.reserve.naverboost.domain.reservation.dto.ReservationInsertReqDto;
import com.reserve.naverboost.domain.reservation.dto.ReservationInsertResDto;
import com.reserve.naverboost.util.exception.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/")
    public CustomResponse<List<ReservationInfoQueryDto>> findbyEmail(
            @RequestParam String email) {
        List<ReservationInfoQueryDto> byReservationInfo = reservationService.findByReservationInfo(email);
        return new CustomResponse<>(byReservationInfo);
    }


    @PostMapping("/")
    public CustomResponse<ReservationInsertResDto> insertReservation(@RequestBody ReservationInsertReqDto req){
        Optional<ReservationInsertReqDto> reqChk = Optional.of(req);
        ReservationInsertResDto res = reservationService.createReservation(req);

        return null;
    }


}
