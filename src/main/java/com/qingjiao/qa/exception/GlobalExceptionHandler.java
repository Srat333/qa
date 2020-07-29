package com.qingjiao.qa.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

  public static String getThrowableStackInfo(Throwable e) {
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    e.printStackTrace(new java.io.PrintWriter(buf,true));
    String msg = buf.toString();
    try {
      buf.close();
    } catch(Exception t) {
      return e.getMessage();
    }
    return msg;
  }

  @ExceptionHandler(value = ArithmeticException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleArithmetic(HttpServletRequest request, HttpServletResponse response,
                                 ArithmeticException e) throws IOException {
    log.error("divide error");
    return "divide 0: "+getThrowableStackInfo(e);
  }

  @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
  public String handleArrayIndexOutBounds(HttpServletRequest request, HttpServletResponse response,
                                          ArrayIndexOutOfBoundsException e) throws IOException {
    log.error("array index out of error");
    return "arrayIndexOutOfBounds: "+getThrowableStackInfo(e);
  }


}
