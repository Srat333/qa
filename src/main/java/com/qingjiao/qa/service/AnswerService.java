package com.qingjiao.qa.service;



import com.qingjiao.qa.entity.Answer;
import com.qingjiao.qa.exception.Result;

public interface AnswerService {



  Result addAnswer(Long qid, String aContent);

  Result updateAnswer(String content, Long aid);

  Result comment(String comment, Long aid, double score);

  Result deleteAnswer(Long aid);

  Answer searchOneQuestion(Long qid);

  Answer searchOneAnswer(Long aid);


}
