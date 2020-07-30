package com.qingjiao.qa.exception;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Result<T> {

  private boolean success;
  private int code;
  private String msg;
  private T data;

  public static Result defineError(DefinitionException de){
    Result result = new Result();
    result.setSuccess(false);
    result.setCode(de.getErrorCode());
    result.setMsg(de.getErrorMsg());
    result.setData(null);
    return result;
  }


  public static Result otherError(ErrorEnum errorEnum){
    Result result = new Result();
    result.setMsg(errorEnum.getErrorMsg());
    result.setCode(errorEnum.getErrorCode());
    result.setSuccess(false);
    result.setData(null);
    return result;
  }



}
