package com.qingjiao.qa.controller;


import com.qingjiao.qa.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/qa")
public class AnswerController {

  @Autowired
  private AnswerService answerService;


  @RequestMapping(value = {"/reply"},method = RequestMethod.POST)
  public void addAnswer(@RequestParam("qid") Long qid,
                        @RequestParam("content") String aContent) {
    answerService.addAnswer(aContent,qid);
  }

  @RequestMapping(value = {"/re-reply"}, method = RequestMethod.POST)
  public void updateAnswer(@RequestParam("content") String content,
                           @RequestParam("aid") Long aid) {
    answerService.updateAnswer(content,aid);
  }

  @RequestMapping(value = {"/comment"},method = RequestMethod.POST)
  public void comment(@RequestParam("comment") String comment,
                      @RequestParam("score") double score,
                      @RequestParam("aid") Long aid) {
    answerService.comment(comment,score,aid);
  }

  @RequestMapping(value = {"/delete_answer"},method = RequestMethod.DELETE)
  public void deleteAnswer(@RequestParam("aid") Long aid) {
    answerService.deleteAnswer(aid);
  }



}
