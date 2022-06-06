package com.reserve.naverboost.domain.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final EntityManager em;



}
