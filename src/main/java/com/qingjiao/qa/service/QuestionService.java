package com.qingjiao.qa.service;


import com.qingjiao.qa.entity.Question;
import com.qingjiao.qa.exception.Result;

import java.util.List;


public interface QuestionService {

  Result addQuestion(String qContent, String tag, String qTitle, String category);

  Result updateQuestion(String qContent, Long qid, String qTitle);

  Result deleteQuestion(Long qid);

  Result searchQuestions(String keyword);

  Question searchOneQuestion(Long qid);

  List<Question> listAllQuestions();

}
