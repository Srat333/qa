package com.qingjiao.qa.controller;


import com.qingjiao.qa.entity.Answer;
import com.qingjiao.qa.exception.ErrorEnum;
import com.qingjiao.qa.exception.Result;
import com.qingjiao.qa.service.AnswerService;
import com.qingjiao.qa.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/qa")
public class AnswerController {

  @Autowired
  private AnswerService answerService;

  @Autowired
  private RedisTemplate redisTemplate;


  @RequestMapping(value = {"/reply"},method = RequestMethod.POST)
  public Result addAnswer(@RequestParam("qid") Long qid,
                          @RequestParam("content") String aContent) {
    if(aContent.equals("") || aContent==null) {
      log.error("answer is empty :(");
    }
    Answer answer = new Answer();
    answer.setAnswerUid(222L);
    Date date = new Date();
    answer.setAnswerTime(date);
    answer.setAContent(aContent);
    answer.setQid(qid);
    boolean flag = answerService.addAnswer(answer);
    redisTemplate.opsForValue().set("answer"+answer.getAid(),answer);
    log.info("saved in redis answer"+" "+answer.getAid());
    Result result = new Result();
    if(flag) {
      return ResultUtil.succ(result,answer,"answer");
    } else {
      return ResultUtil.error(result);
    }

  }

  @RequestMapping(value = {"/re-reply"}, method = RequestMethod.POST)
  public Result updateAnswer(@RequestParam("content") String content,
                           @RequestParam("aid") Long aid) {
    if(content.equals("") || content==null) {
      log.error("re-answer is empty :(");
      return ResultUtil.empty(new Result());
    }
    Answer answer = (Answer)redisTemplate.opsForValue().get("answer"+aid);
    if(answer==null)
      answer = answerService.searchOneAnswer(aid);
    answer.setAContent(content);
    answer.setAnswerTime(new Date());
    boolean flag = answerService.updateAnswer(answer);
    redisTemplate.opsForValue().set("answer"+aid,answer);
    Result result = new Result();
    if(flag) {
      return ResultUtil.succ(result,answer,"re-reply");
    } else {
      return ResultUtil.error(result);
    }
  }

  @RequestMapping(value = {"/comment"},method = RequestMethod.POST)
  public Result comment(@RequestParam("comment") String comment,
                      @RequestParam("score") double score,
                      @RequestParam("aid") Long aid) {
    if(comment.equals("") || comment==null || score<0.0 || score>5.0) {
      log.error("comment or score are none or out of scope");
      return ResultUtil.empty(new Result());
    }
    Answer answer = (Answer)redisTemplate.opsForValue().get("answer"+aid);
    if(answer==null)
      answer = answerService.searchOneAnswer(aid);
    if(answer==null)
      return ResultUtil.empty(new Result());
    answer.setComment(comment);
    answer.setScore(score);
    boolean flag = answerService.comment(answer);
    redisTemplate.opsForValue().set("answer"+answer.getAid(),answer);
    Result result = new Result();
    if(flag) {
      return ResultUtil.succ(result,answer,"comment");
    } else {
      return ResultUtil.error(result);
    }

  }

  @RequestMapping(value = {"/delete_answer"},method = RequestMethod.DELETE)
  public Result deleteAnswer(@RequestParam("aid") Long aid) {
    Answer answer = (Answer)redisTemplate.opsForValue().get("answer"+aid);
    if(StringUtils.isEmpty(answer))
      answer = answerService.searchOneAnswer(aid);
    if(StringUtils.isEmpty(answer))
      return ResultUtil.empty(new Result());
    log.info(answer.toString());
    boolean flag = answerService.deleteAnswer(aid);
    log.info(String.valueOf(flag));
    redisTemplate.delete("answer"+aid);
    Result result = new Result();
    if(flag) {
      return ResultUtil.succ(result,null,"delete");
    } else {
      log.error(String.valueOf(flag));
      return ResultUtil.error(result);
    }
  }




}
