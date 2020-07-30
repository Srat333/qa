package com.qingjiao.qa.service.Impl;


import com.qingjiao.qa.dao.QuestionDao;
import com.qingjiao.qa.entity.Question;
import com.qingjiao.qa.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

  @Resource
  private QuestionDao questionDao;

  @Autowired
  private ResourceLoader resourceLoader;


  @Override
  public boolean addQuestion(Question question) {

    int result = questionDao.addQuestion(question);

    if(result!=-1) {
      log.info("ask a question successfully :) "+new Date()+" good luck <3");
      return true;
    } else {
      log.error("add failure :(");
      return false;
    }

  }



  public boolean updateQuestion(Question question) {
    int result = questionDao.updateQuestion(question);
    if(result<0) {
      log.error("update failure :(");
      return false;
    } else {
      log.info("update successfully :)");
      return true;
    }

  }

  public List<Question> searchQuestion(String keyword) {
    if(keyword.equals("") || keyword==null) {
      return new ArrayList<Question>();
    }
    return questionDao.searchQuestions(keyword);

  }

  public Question searchOneQuestion(Long qid) {
    if(qid<=0) {
      return null;
    }
    return questionDao.searchOneQuestion(qid);
  }


  public boolean deleteQuestion(Long qid) {
    int result = questionDao.deleteQuestion(qid);
    if(result<0) {
      log.error("delete failure :(");
      return false;
    } else {
      log.info("delete successfully :)");
      return true;
    }
  }


  public List<Question> listAllQuestions() {
    return questionDao.listAllQuestion();

  }

  public boolean uploadPicture() {
    return false;
  }



}
