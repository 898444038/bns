package com.ming.bns.admin.controller.sys;

import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public ResultMsg globalException(HttpServletResponse response, NullPointerException ex){
//        log.info("GlobalExceptionHandler...");
//        log.info("错误代码：" + response.getStatus());
//        BaseResult result = new WebResult(WebResult.RESULT_FAIL,"request error:"+response.getStatus()
//                ,"GlobalExceptionHandler:"+ex.getMessage());
        return ResultMsg.error(ex.getMessage());
    }
}
