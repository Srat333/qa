package com.qingjiao.qa.service;


import com.qingjiao.qa.dao.AnswerDao;
import com.qingjiao.qa.entity.Answer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class AnswerService {

  @Autowired
  private AnswerDao answerDao;

  public boolean addAnswer(String a_content,Long qid) {
    if(a_content.equals("") || a_content==null) {
      log.error("answer is empty :(");
      return false;
    }
    Answer answer = new Answer();
    answer.setAnswerUid(222L);
    Date date = new Date();
    answer.setAnswerTime(date);
    answer.setAContent(a_content);
    answer.setQid(qid);
    int index = answerDao.addAnswer(answer);
    if(index<0) {
      log.error("add answer failure :(");
      return false;
    } else {
      log.info("add answer successfully :)");
      return true;
    }
  }

  public boolean updateAnswer(String a_content,Long aid) {
    if(a_content.equals("") || a_content==null) {
      log.error("re-answer is empty :(");
      return false;
    }
    int index = answerDao.updateAnswer(a_content,aid);
    if(index<0) {
      log.error("update answer failure :(");
      return false;
    } else {
      log.info("update answer successfully :)");
      return true;
    }

  }

  public boolean comment(String comment,double score,Long aid) {
    if(comment.equals("") || comment==null || score<0.0 || score>5.0) {
      log.error("comment or score are none or out of scope");
      return false;
    }
    int index = answerDao.comment(comment,score,aid);
    if(index<0) {
      log.error("comment failure :(");
      return false;
    } else {
      log.info("comment successfully :)");
      return true;
    }

  }

  public boolean deleteAnswer(Long aid) {
    if(aid<0) {
      log.error("invalid aid");
      return false;
    }
    int result = answerDao.deleteAnswer(aid);
    if(result<0) {
      log.error("delete answer failure :(");
      return false;
    } else {
      log.info("delete answer successfully :)");
      return true;
    }
  }

  public Answer searchOneQuestion(Long qid) {
    if(qid<0) {
      log.error("invalid qid");
      return null;
    }
    Answer answer = answerDao.searchOneQuestion(qid);
    if(answer==null) {
      log.error("answer not exist");
      return null;
    }
    return answer;
  }


}
