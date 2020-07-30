package com.qingjiao.qa.service;


import com.qingjiao.qa.dao.AnswerDao;
import com.qingjiao.qa.entity.Answer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


public interface AnswerService {



  boolean addAnswer(Answer answer);

  boolean updateAnswer(Answer answer);

  boolean comment(Answer answer);

  boolean deleteAnswer(Long aid);

  Answer searchOneQuestion(Long qid);

  Answer searchOneAnswer(Long aid);


}
