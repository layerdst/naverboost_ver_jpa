package com.reserve.naverboost.util.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"statusCode", "message", "result"})
@AllArgsConstructor
public class CustomResponse<T> {
    private final String message;
    private final int statusCode;
    private T result;

    public CustomResponse(T result){
        this.message = "성공";
        this.statusCode = 200;
        this.result = result;
    }

    public CustomResponse(CustomResponseStatus status){
        this.message = status.getMessage();
        this.statusCode = status.getCode();
    }

}
