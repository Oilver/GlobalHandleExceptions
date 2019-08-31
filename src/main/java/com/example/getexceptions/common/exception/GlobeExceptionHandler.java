package com.example.getexceptions.common.exception;

import com.example.getexceptions.common.response.Response;
import com.example.getexceptions.common.response.ResponseCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author hdeng
 */
@ControllerAdvice
public class GlobeExceptionHandler {

    private static HashMap<Class<? extends Throwable>, ResponseCode> EXCEPTIONS = new HashMap<>();

    //运行时异常
    static {
        EXCEPTIONS.put(NullPointerException.class, ResponseCode.NULL_EXCEPTION);
        EXCEPTIONS.put(ArithmeticException.class, ResponseCode.ARITH_EXCEPTION);
    }

    @ExceptionHandler
    @ResponseBody
    public Response customException(CustomException e) {
        return Response.createByErrorCode(e.getResponseCode());
    }

    @ExceptionHandler
    @ResponseBody
    public Response exception(Exception e) {
        if (null == EXCEPTIONS.get(e.getClass())) {
            return Response.createByErrorCode(ResponseCode.COMMON_ERROR);
        } else {
            return Response.createByErrorCode(EXCEPTIONS.get(e.getClass()));
        }
    }
}
