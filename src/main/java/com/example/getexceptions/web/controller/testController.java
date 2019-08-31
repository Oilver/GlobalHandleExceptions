package com.example.getexceptions.web.controller;

import com.example.getexceptions.common.exception.ExceptionThrow;
import com.example.getexceptions.common.response.Response;
import com.example.getexceptions.common.response.ResponseCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hdeng
 */
@RestController
public class testController {

    @RequestMapping("testCustomException")
    public Response testCustomException() {
        boolean needLogin = true;
        ExceptionThrow.cast(ResponseCode.NEED_LOGIN, needLogin);
        return Response.createBySuccess();
    }

    @RequestMapping("testRuntimeException1")
    public Response test2() {
        int a = 5 / 0;
        return Response.createBySuccess();
    }

    @RequestMapping("testRuntimeException2")
    public Response test3() {
        String a = null;
        System.out.println(a.equals("1"));
        return Response.createBySuccess();
    }
}
