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


}
