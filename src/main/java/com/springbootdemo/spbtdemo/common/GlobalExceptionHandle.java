package com.springbootdemo.spbtdemo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author : QinZhen
 * @Date : 2020/11/17 11:37 下午
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandle {

    //业务异常
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ServiceException.class})
    public ResultDto serviceExceptionHandler(ServiceException se){
//        log.error(se.getMessage());
        return resultFormat(se);
    }

    @ExceptionHandler({Exception.class})
    public ResultDto exceptionHandler(Exception e){
//        log.error(e.getMessage());
        return resultFormat(e);
    }

    @ExceptionHandler({Throwable.class})
    public ResultDto throwableException(Throwable t){
        log.error(t.getMessage());
        return ResultDto.fail("系统异常，请稍后重试");
    }

    public ResultDto resultFormat(Throwable t){
        log.error(t.getMessage());
        String tips = "系统繁忙，请稍后重试";

        if (t instanceof ServiceException){
            return ResultDto.fail("业务异常:" + tips);
        }
        if (t instanceof Exception){
            return ResultDto.fail("非业务异常：" + tips);
        }

        return ResultDto.fail(tips);
    }


}
