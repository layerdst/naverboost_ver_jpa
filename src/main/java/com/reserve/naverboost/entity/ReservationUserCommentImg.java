package com.reserve.naverboost.entity;

import com.reserve.naverboost.entity.auditing.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class ReservationUserCommentImg extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name="reservation_user_comment_img_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="reservation_info_id")
    private ReservationInfo reservationInfo;

    @ManyToOne
    @JoinColumn(name="reservation_user_comment_id")
    private ReservationUserComment reservationUserComment;

    @ManyToOne
    @JoinColumn(name="file_info_id")
    private FileInfo fileInfo;



}
