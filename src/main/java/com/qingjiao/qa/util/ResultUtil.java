package com.qingjiao.qa.util;

import com.qingjiao.qa.entity.Answer;
import com.qingjiao.qa.entity.Order;
import com.qingjiao.qa.entity.Question;
import com.qingjiao.qa.exception.DefinitionException;
import com.qingjiao.qa.exception.ErrorEnum;
import com.qingjiao.qa.exception.Result;

import java.util.List;

public class ResultUtil<T> {

  public static Result error(Result result) {
    result.setCode(500);
    result.setSuccess(false);
    result.setData(null);
    result.setMsg("Internal Server Error :(");
    return result;
  }

  public static Result succ(Result result, Answer answer, String option) {
    result.setCode(200);
    result.setSuccess(true);
    result.setData(answer);
    result.setMsg(option+"a answer succ :) <3");
    return result;
  }

  public static Result empty(Result result) {
    result.setCode(ErrorEnum.BAD_REQUEST.getErrorCode());
    result.setSuccess(false);
    result.setData(null);
    result.setMsg(ErrorEnum.BAD_REQUEST.getErrorMsg());
    return result;
  }

  public static Result qSucc(Result result, Question question, String option) {
    result.setCode(200);
    result.setSuccess(true);
    result.setData(question);
    result.setMsg(option+"a question succ :) <3");
    return result;
  }

  public static Result oSucc(Result result, Order order, String option) {
    result.setCode(200);
    result.setSuccess(true);
    result.setData(order);
    result.setMsg(option+"a order succ :) <3");
    return result;
  }

  public static Result SearchSucc(Result result, List item,String options) {
    result.setCode(200);
    result.setSuccess(true);
    result.setData(item);
    result.setMsg("search "+options+"s succ :) <3");
    return result;
  }

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
