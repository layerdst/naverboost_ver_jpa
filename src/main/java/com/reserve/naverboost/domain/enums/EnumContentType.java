package com.reserve.naverboost.domain.enums;


import com.reserve.naverboost.exception.CustomException;
import com.reserve.naverboost.exception.CustomResponse;
import com.reserve.naverboost.exception.CustomResponseStatus;

import java.util.Optional;

public enum EnumContentType {
    PNG("image/png"),
    JPEG("image/png"),
    JPG("image/png"),
    BMP("image/png");

    private final String contentType;

    EnumContentType(String contentType){
        this.contentType = contentType;
    }

    String getContentType(){
        return this.contentType;
    }

    public String checkEnumContentType(String getContentType) throws CustomException{

        String checkType = blankCheck(getContentType);
        for(EnumContentType enumContentType : EnumContentType.values()){
            if(enumContentType.getContentType().equals(getContentType)){
                return enumContentType.getContentType();
            }
        }
        throw new CustomException(CustomResponseStatus.DB_ERR);
    }

    public String blankCheck(String checkData) throws CustomException{
        return Optional.ofNullable(checkData).filter(s -> !s.isBlank())
                .map(String::new)
                .orElseThrow(() -> new CustomException(CustomResponseStatus.DB_ERR));
    }




}
