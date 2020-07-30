package com.qingjiao.qa.service;


import com.qingjiao.qa.entity.Question;

import java.util.List;


public interface QuestionService {

  boolean addQuestion(Question question);

  boolean updateQuestion(Question question);

  boolean deleteQuestion(Long qid);

  List<Question> searchQuestion(String keyword);

  Question searchOneQuestion(Long qid);

  List<Question> listAllQuestions();

}
