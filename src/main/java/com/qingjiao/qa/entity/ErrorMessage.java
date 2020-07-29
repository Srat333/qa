package com.qingjiao.qa.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class ErrorMessage<T> {

  private int code;
  private String message;
  private Collection<T> data;

  public static ErrorMessage error(int code, String message) {
    ErrorMessage errorMessage = new ErrorMessage();
    errorMessage.setCode(code);
    errorMessage.setMessage(message);
    return errorMessage;
  }

  public static ErrorMessage success() {
    ErrorMessage errorMessage = new ErrorMessage();
    errorMessage.setCode(200);
    errorMessage.setMessage("success:)");
    return errorMessage;
  }

  public static <V> ErrorMessage<V> success(Collection<V> data) {
    ErrorMessage errorMessage = new ErrorMessage();
    errorMessage.setCode(200);
    errorMessage.setMessage("success:)");
    errorMessage.setData(data);
    return errorMessage;
  }

}
