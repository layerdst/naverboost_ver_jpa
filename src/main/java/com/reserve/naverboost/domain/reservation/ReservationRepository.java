package com.reserve.naverboost.domain.reservation;

import com.reserve.naverboost.domain.reservation.dto.ReservationDisplayInfoQueryDto;
import com.reserve.naverboost.domain.reservation.dto.ReservationInfoQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final EntityManager em;

    private List<ReservationInfoQueryDto> findByReservationByEmail(String email){
        return em.createQuery("select new com.reserve.naverboost.domain.reservation.dto.ReservationInfoQueryDto" +
                "( r.id, p.id, d.id, r.reservationName, r.reservationTel, r.reservationEmail, r.cancelFlag, r.reservationDate, r.createdDate, r.lastModifiedDate, rp.count*pr.price*(1-pr.discountRate) )" +
                "from ReservationInfo r " +
                "join r.displayInfo d " +
                "join r.product p " +
                "join r.reservationInfoPrices rp " +
                "join rp.productPrice pr " +
                "where r.reservationEmail = :email")
                .setParameter("email", email)
                .getResultList();
    }

    private List<ReservationDisplayInfoQueryDto> ReservationInQuery(int[] arr ){
        return em.createQuery("select new com.reserve.naverboost.domain.reservation.dto.ReservationDisplayInfoQueryDto(p.id, c.id, d.id, c.categoryName, p.description, p.content, p.event, d.openingHours, d.placeLot, d.placeStreet, d.tel, d.homepage, d.email, d.createdDate, d.lastModifiedDate)" +
                "from DisplayInfo d " +
                "join d.product p " +
                "join p.category c " +
                "where d.id = :id").setParameter("id", arr).getResultList();
    }



}
