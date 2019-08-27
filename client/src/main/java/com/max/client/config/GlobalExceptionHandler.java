package com.max.client.config;

import com.max.core.exception.ServiceException;
import com.max.core.result.Result;
import com.max.core.result.ResultCode;
import com.max.core.result.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.validation.BindException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler()
    @ResponseBody
    Result handleBindException(BindException e){
        log.warn("参数校验失败{}",e.getFieldErrors());
        return ResultGenerator.genFailResult(ResultCode.ARGS_FAIL);
    }
    @ExceptionHandler()
    @ResponseBody
    Result handleBindException(DuplicateKeyException e){
        log.warn("数据已存在{}",e.getMessage());
        return ResultGenerator.genFailResult(ResultCode.INVALID_PARAM);
    }

    @ExceptionHandler()
    @ResponseBody
    Result handleServiceException(ServiceException e){
        return ResultGenerator.genFailResult(e.getCode(), e.getMessage());
    }
    @ExceptionHandler()
    @ResponseBody
    Result handleIllegalArgumentException(IllegalArgumentException e){
        log.warn("参数不正确{}",e);
        return ResultGenerator.genFailResult(ResultCode.ARGS_FAIL);
    }
    @ExceptionHandler()
    @ResponseBody
    Result handleException(Exception e){
        log.error("系统异常{}",e);
        return ResultGenerator.genFailResult(ResultCode.FAIL);
    }
}
