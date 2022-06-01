package com.reserve.naverboost.entity;

import com.reserve.naverboost.domain.dto.req.FileInfoDtoReq;
import com.reserve.naverboost.entity.auditing.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
public class DisplayInfoImage extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name="display_info_image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="display_info_id")
    private DisplayInfo displayInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="file_info_id")
    private FileInfo fileInfo;

    public DisplayInfoImage(){

    }

    DisplayInfoImage(DisplayInfo displayInfo, FileInfoDtoReq req) {
        this.displayInfo = displayInfo;
        this.fileInfo = FileInfo.createFileInfo(req);
    }

    public static DisplayInfoImage createDisplayInfoImg(DisplayInfo displayInfo, FileInfoDtoReq req){
        return new DisplayInfoImage(displayInfo, req);
    }
}
