package com.qingjiao.qa.controller;


import com.qingjiao.qa.exception.Result;
import com.qingjiao.qa.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/qa")
public class AnswerController {

  @Autowired
  private AnswerService answerService;


  @RequestMapping(value = {"/reply"},method = RequestMethod.POST)
  public Result addAnswer(@RequestParam("qid") Long qid,
                          @RequestParam("content") String aContent,
                          @RequestParam("uid") String uid) {
    return answerService.addAnswer(qid,aContent,uid);
  }

  @RequestMapping(value = {"/re-reply"}, method = RequestMethod.POST)
  public Result updateAnswer(@RequestParam("content") String content,
                           @RequestParam("aid") Long aid) {
    return answerService.updateAnswer(content,aid);
  }

  @RequestMapping(value = {"/comment"},method = RequestMethod.POST)
  public Result comment(@RequestParam("comment") String comment,
                      @RequestParam("score") double score,
                      @RequestParam("aid") Long aid) {

    return answerService.comment(comment,aid,score);

  }

  @RequestMapping(value = {"/delete_answer"},method = RequestMethod.DELETE)
  public Result deleteAnswer(@RequestParam("aid") Long aid) {
    return answerService.deleteAnswer(aid);

  }

  @RequestMapping(value = {"/user_a"},method = RequestMethod.GET)
  public Result searchAnswersByUid(@RequestParam("uid") String uid) {
    return answerService.searchAnswersByUid(uid);
  }


}
