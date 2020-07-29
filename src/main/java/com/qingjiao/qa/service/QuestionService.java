package com.qingjiao.qa.service;

import com.qingjiao.qa.dao.QuestionDao;
import com.qingjiao.qa.entity.Question;
import com.qingjiao.qa.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class QuestionService {

  @Autowired
  private QuestionDao questionDao;

  @Autowired
  private ResourceLoader resourceLoader;

  public boolean addQuestion(String q_title, long uid, String q_content, String category,String tag) {
    if(q_content.equals("") || tag.equals("")) {
      log.error("content empty");
      return false;
    }

   // String path = "";
   // String fileName = pic.getOriginalFilename();


    Date curDate = new Date();
    Question q = new Question();
   // q.setQid(0L);
    q.setQuestion_uid(uid);
    q.setQ_title(q_title);
    q.setQ_content(q_content);
    q.setCategory(category);
    q.setTag(tag);
    q.setPrice(0.99);
    q.setCreate_time(curDate);
    int result=-1;
    try {
      if(questionDao!=null)
        result = questionDao.addQuestion(q);
    } catch (Exception e){
      log.error("add exception happened :(");
      e.printStackTrace();
    }
    if(result!=-1) {
      log.info("ask a question successfully :) "+curDate+" good luck <3");
      return true;
    } else {
      log.error("add failure :(");
      return false;
    }

  }

  public boolean updateQuestion(String qTitle, String qContent,Long qid) {
    if(qContent.equals("")  || qContent==null || qid<=0 || qTitle.equals("") || qTitle==null) {
      log.error("content empty or qid invalid");
      return false;
    }
    int result = questionDao.updateQuestion(qTitle,qContent,qid);
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
    if(qid<0) {
      return false;
    }
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
