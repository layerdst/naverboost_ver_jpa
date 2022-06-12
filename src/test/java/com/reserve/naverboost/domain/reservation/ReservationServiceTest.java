package com.reserve.naverboost.domain.reservation;

import com.reserve.naverboost.domain.reservation.dto.ReservationInfoQueryDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationServiceTest {

    @Autowired
    private ReservationService reservationService;


    @Test
    @DisplayName("예약정보 가져오기")
    public void test() throws Exception{
        //given
        List<ReservationInfoQueryDto> result = reservationService.findByReservationInfo("이메일");
        //when

        System.out.println(result.get(0).getDisplayInfoDto().getCategoryName());
        //then
    }


}