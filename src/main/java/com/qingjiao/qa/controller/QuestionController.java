package com.qingjiao.qa.controller;


import com.qingjiao.qa.entity.Question;
import com.qingjiao.qa.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @RequestMapping(value={"/all"},method = RequestMethod.GET)
  public List<Question> listAllQuestions() {
    List<Question> result = questionService.listAllQuestions();
    if(result!=null) {
      System.out.println("list all successfully!!!!");
      return result;
    } else {
      System.out.println("list add :(");
      return null;
    }
  }



}
