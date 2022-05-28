package com.reserve.naverboost.domain.dto.req;

import com.reserve.naverboost.domain.enums.EnumContentType;
import com.reserve.naverboost.domain.enums.EnumImageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileInfoDtoReq {

    private Long id;
    private String fileName;
    private String saveFileName;
    private EnumImageType imgType;
    private EnumContentType contentType;
    private boolean deleteFlag;


    public FileInfoDtoReq(String fileName, String saveFileName, EnumImageType imgType, EnumContentType contentType){
        this.fileName = fileName;
        this.saveFileName = saveFileName;
        this.imgType = imgType;
        this.contentType = contentType;

    }

    public FileInfoDtoReq(Long id, boolean deleteFlag){
        this.id = id;
        this.deleteFlag = deleteFlag;
    }

    public static FileInfoDtoReq createFileInfo (String fileName, String saveFileName, EnumImageType imgType, EnumContentType contentType){
        return new FileInfoDtoReq(fileName, saveFileName, imgType, contentType);
    }

    public static FileInfoDtoReq deleteFileInfo(Long id, boolean deleteFlag){
        return new FileInfoDtoReq(id, deleteFlag);
    }

}
