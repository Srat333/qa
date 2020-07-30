package com.qingjiao.qa.util;

import com.qingjiao.qa.entity.Answer;
import com.qingjiao.qa.entity.Question;
import com.qingjiao.qa.exception.ErrorEnum;
import com.qingjiao.qa.exception.Result;

import java.util.List;

public class ResultUtil<T> {

  public static Result error(Result result) {
    result.setCode(500);
    result.setSuccess(false);
    result.setData(null);
    result.setMsg("Internal Server Error");
    return result;
  }

  public static Result succ(Result result, Answer answer) {
    result.setCode(200);
    result.setSuccess(true);
    result.setData(answer);
    result.setMsg("add a answer succ :) <3");
    return result;
  }

  public static Result empty(Result result) {
    result.setCode(ErrorEnum.BAD_REQUEST.getErrorCode());
    result.setSuccess(false);
    result.setData(null);
    result.setMsg(ErrorEnum.BAD_REQUEST.getErrorMsg());
    return result;
  }

  public static Result qSucc(Result result, Question question) {
    result.setCode(200);
    result.setSuccess(true);
    result.setData(question);
    result.setMsg("add a question succ :) <3");
    return result;
  }

  public static Result SearchQuestionSucc(Result result, List<Question> question) {
    result.setCode(200);
    result.setSuccess(true);
    result.setData(question);
    result.setMsg("search questions succ :) <3");
    return result;
  }

}
