package com.qingjiao.qa.service.Impl;

import com.qingjiao.qa.dao.AnswerDao;
import com.qingjiao.qa.entity.Answer;
import com.qingjiao.qa.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Slf4j
@Service
public class AnswerServiceImpl implements AnswerService {

  @Resource
  private AnswerDao answerDao;



  @Override
  public boolean addAnswer(Answer answer) {
    int index = answerDao.addAnswer(answer);
    if(index<0) {
      log.error("add answer failure :(");
      return false;
    } else {
      log.info("add answer successfully :)");
      return true;
    }
  }


  @Override
  public boolean updateAnswer(Answer a) {
    int index = answerDao.updateAnswer(a);
    if(index<0) {
      log.error("update answer failure :(");
      return false;
    } else {
      log.info("update answer successfully :)");
      return true;
    }

  }


  @Override
  public boolean comment(Answer answer) {

    int index = answerDao.comment(answer);
    if(index<0) {
      log.error("comment failure :(");
      return false;
    } else {
      log.info("comment successfully :)");
      return true;
    }

  }

  @Override
  public boolean deleteAnswer(Long aid) {

    int result = answerDao.deleteAnswer(aid);
    log.info(String.valueOf(result));
    if(result<0) {
      log.error("delete answer failure :(");
      return false;
    } else {
      log.info("delete answer successfully :)");
      return true;
    }
  }


  @Override
  public Answer searchOneQuestion(Long qid) {
    if(qid<0) {
      log.error("invalid qid :(");
      return null;
    }
    Answer answer = answerDao.searchOneQuestion(qid);
    if(answer==null) {
      log.error("answer not exist :(");
      return null;
    }
    return answer;
  }

  @Override
  public Answer searchOneAnswer(Long aid) {
    if(aid<0) {
      log.error("invalid aid :(");
      return null;
    }
    Answer answer = answerDao.searchOneAnswer(aid);
    if(answer == null) {
      log.error("answer not exist :(");
    }
    return answer;
  }

}
