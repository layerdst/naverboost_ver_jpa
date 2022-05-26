package com.reserve.naverboost.domain;

import javax.persistence.*;
import java.io.File;

@Entity
public class ReservationUserCommentImg {

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
