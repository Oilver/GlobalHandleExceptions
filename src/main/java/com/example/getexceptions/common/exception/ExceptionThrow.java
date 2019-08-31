package com.example.getexceptions.common.exception;

import com.example.getexceptions.common.response.ResponseCode;

/**
 * @author hdeng
 */
public class ExceptionThrow {
    public static void cast(ResponseCode responseCode, boolean condition) {
        if (condition) {
            throw new CustomException(responseCode);
        }
    }
}
