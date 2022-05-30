package com.reserve.naverboost.util.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Supplier;

@AllArgsConstructor
@Getter
public class CustomException extends Exception {
    private CustomResponseStatus status;


}
