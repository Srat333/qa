package com.qingjiao.qa.controller;


import com.qingjiao.qa.entity.Question;
import com.qingjiao.qa.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/qa")
public class QuestionController {

  @Autowired
  private QuestionService questionService;

  @RequestMapping(value={"/add"},method = RequestMethod.POST)
  public void addQuestion(@RequestParam("content") String qContent, @RequestParam("tag") String tag) {

    boolean result = questionService.addQuestion(qContent,tag);
    if(result)
      System.out.println("add questions successfully!!!!!");
    else {
      System.out.println("add:(");
    }
  }


  @RequestMapping(value={"/update"},method = RequestMethod.POST)
  public void updateQuestion(@RequestParam("content") String qContent,
                             @RequestParam("qid") Long qid) {
    if(questionService.searchOneQuestion(qid)==null) {
      log.error("question not found :3");
    }
    boolean result = questionService.updateQuestion(qContent,qid);
    if(result) {
      log.info("update succ :)");
    } else {
      log.error("update failed :(");
    }
  }

  @RequestMapping(value={"/search"},method = RequestMethod.GET)
  public List<Question> searchQuestions(@RequestParam("keyword") String keyword) {
    List<Question> result = questionService.searchQuestion(keyword);
    if(result==null) {
      log.info("no similar results");
    } else {
      log.info("found something");
    }
    return result;
  }

  @RequestMapping(value={"/delete"},method = RequestMethod.DELETE)
  public void deleteQuestion(@RequestParam("qid") Long qid) {
    if(questionService.searchOneQuestion(qid)==null) {
      log.error("question not found :8");
      return;
    }
    boolean result = questionService.deleteQuestion(qid);
    if(result) {
      log.info("delete succ :)");
    } else {
      log.error("delete failed :(");
    }
  }

  @RequestMapping(value={"/all"},method = RequestMethod.GET)
  public List<Question> listAllQuestions() {
    List<Question> result = questionService.listAllQuestions();
    if(result!=null) {
      log.info("list all successfully!!!!");
      return result;
    } else {
      log.error("list add :(");
      return null;
    }
  }



}
