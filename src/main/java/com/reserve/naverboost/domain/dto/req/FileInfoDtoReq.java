package com.reserve.naverboost.domain.dto.req;

import com.reserve.naverboost.domain.enums.EnumImageType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileInfoDtoReq {

    private Long id;
    private String fileName;
    private String saveFileName;
    private EnumImageType imgType;
    private boolean deleteFlag;


    public FileInfoDtoReq(String fileName, String saveFileName, EnumImageType imgType){
        this.fileName = fileName;
        this.saveFileName = saveFileName;
        this.imgType = imgType;
    }

    public FileInfoDtoReq(Long id, boolean deleteFlag){
        this.id = id;
        this.deleteFlag = deleteFlag;
    }

    public FileInfoDtoReq createFileInfo (String fileName, String saveFileName, EnumImageType imgType){
        return new FileInfoDtoReq(fileName, saveFileName, imgType);
    }

    public FileInfoDtoReq deleteFileInfo(Long id, boolean deleteFlag){
        return new FileInfoDtoReq(id, deleteFlag);
    }

}
