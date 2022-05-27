package com.reserve.naverboost.domain;

import com.reserve.naverboost.domain.enums.EnumContentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class FileInfo {

    @Id
    @GeneratedValue
    @Column(name = "file_info_id")
    private Long id;

    private String fileName;

    private String saveFileName;

    /*
        img/jpeg, img/jpg, img/bmp, img/png 등등
     */
    @Enumerated(value = EnumType.STRING)
    private EnumContentType contentType;

    @Column(name="delete_flag")
    private boolean deleteFlag;





}
