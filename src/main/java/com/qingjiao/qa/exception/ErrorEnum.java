package com.qingjiao.qa.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorEnum {

  SUCCESS(200,"OK"),
  NO_PERMISSION(403,"You are not admins"),
  NO_AUTH(401,"Login PLZ"),
  NOT_FOUND(404,"SOS"),
  INTERNAL_SERVER_ERROR(500,"Siberia Potato Field Work"),
  BAD_REQUEST(400,"Bad Request"),
  ;

  private Integer errorCode;
  private String errorMsg;




}
