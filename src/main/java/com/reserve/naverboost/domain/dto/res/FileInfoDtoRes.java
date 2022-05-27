package com.reserve.naverboost.domain.dto.res;

import com.reserve.naverboost.domain.enums.EnumImageType;
import lombok.Getter;

@Getter
public class FileInfoDtoRes {
    private Long id;
    private String fileName;
    private String saveFileName;
    private EnumImageType imgType;
    private boolean deleteFlag;

    public FileInfoDtoRes(Long id, String fileName, String saveFileName, EnumImageType imgType, boolean deleteFlag) {
        this.id = id;
        this.fileName = fileName;
        this.saveFileName = saveFileName;
        this.imgType = imgType;
        this.deleteFlag = deleteFlag;
    }

    FileInfoDtoRes res(Long id, String fileName, String saveFileName, EnumImageType imgType, boolean deleteFlag){
        return new FileInfoDtoRes(id, fileName, saveFileName, imgType, deleteFlag);
    }
}
