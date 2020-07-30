package com.qingjiao.qa.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = DefinitionException.class)
  @ResponseBody
  public Result bizExceptionHandler(DefinitionException e) {
    return Result.defineError(e);
  }

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Result exceptionHandler(Exception e) {
    return Result.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
  }

}
