package com.reserve.naverboost.util.exception;

import lombok.Getter;

@Getter
public enum CustomResponseStatus {


    DB_ERR(500, "데이터베이스 에러");


    private final int code;
    private final String message;

    CustomResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
