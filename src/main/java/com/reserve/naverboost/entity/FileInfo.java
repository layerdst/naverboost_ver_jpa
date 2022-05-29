package com.reserve.naverboost.entity;

import com.reserve.naverboost.entity.auditing.BaseTimeEntity;
import com.reserve.naverboost.domain.dto.req.FileInfoDtoReq;
import com.reserve.naverboost.entity.enums.EnumContentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FileInfo extends BaseTimeEntity {

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
    @ColumnDefault("false")
    private boolean deleteFlag;

    FileInfo(String fileName, String saveFileName, EnumContentType contentType){
        this.fileName = fileName;
        this.saveFileName = saveFileName;
        this.contentType = contentType;
    }

    public static FileInfo createFileInfo(FileInfoDtoReq fileInfoDtoReq){
        return new FileInfo(fileInfoDtoReq.getFileName(),
                            fileInfoDtoReq.getSaveFileName(),
                            fileInfoDtoReq.getContentType());
    }





}
