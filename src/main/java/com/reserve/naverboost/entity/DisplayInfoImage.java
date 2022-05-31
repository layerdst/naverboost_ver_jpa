package com.reserve.naverboost.entity;

import com.reserve.naverboost.domain.dto.req.FileInfoDtoReq;
import com.reserve.naverboost.entity.auditing.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class DisplayInfoImage extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name="display_info_image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="display_info_id")
    private DisplayInfo displayInfo;

    @ManyToOne
    @JoinColumn(name="file_info_id")
    private FileInfo fileInfo;

    public DisplayInfoImage(DisplayInfo displayInfo, FileInfoDtoReq req) {
        this.displayInfo = displayInfo;
        this.fileInfo = FileInfo.createFileInfo(req);
    }

    public DisplayInfoImage createDisplayInfoImg(DisplayInfo displayInfo, FileInfoDtoReq req){
        return new DisplayInfoImage(displayInfo, req);
    }
}
