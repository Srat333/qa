package com.qingjiao.qa.service;

import com.qingjiao.qa.dao.QuestionDao;
import com.qingjiao.qa.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class QuestionService {

  @Autowired
  private QuestionDao questionDao;

  public boolean addQuestion(String q_content, String tag) {
    if(q_content.equals("") || tag.equals("")) {
      return false;
    }
    //questionDao.addQuestion(question);

    Date curDate = new Date();
    Question q = new Question();
    q.setQid(0L);
  //  q.setQuestionUid(111L);
    q.setQ_content(q_content);
    q.setTag(tag);
    q.setPrice(0.99);
    q.setCreate_time(curDate);
    int result=-1;
    try {
      if(questionDao!=null)
        result = questionDao.addQuestion(q);
    } catch (Exception e){
      e.printStackTrace();
    }
    if(result!=-1) {
      System.out.println("ask a question successfully :) "+curDate+" good luck <3");
      return true;
    } else {
      System.out.println("failure :(");
      return false;
    }

  }

  public boolean updateQuestion(String qContent) {

  }

  public boolean deleteQuestion(int qid) {

  }


  public List<Question> listAllQuestions() {
    List<Question> questions = questionDao.listAllQuestion();
    return questions;
  }





}
