package com.qingjiao.qa.controller;


import com.qingjiao.qa.entity.Question;
import com.qingjiao.qa.exception.Result;
import com.qingjiao.qa.service.QuestionService;
import com.qingjiao.qa.util.FileUtils;
import com.qingjiao.qa.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/qa")
public class QuestionController {

  @Autowired
  private QuestionService questionService;

  @Autowired
  private RedisTemplate redisTemplate;

  @RequestMapping(value={"/add"},method = RequestMethod.POST)
  public Result addQuestion(@RequestParam("title") String qTitle,
                            @RequestParam("content") String qContent,
                            @RequestParam("category") String category,
                            @RequestParam("tag") String tag) {
    if(qContent.equals("") || tag.equals("")) {
      log.error("content empty");
      return ResultUtil.empty(new Result());
    }
    Date curDate = new Date();
    Question q = new Question();
    // q.setQid(0L);
    q.setQuestion_uid(111L);
    q.setQ_title(qTitle);
    q.setQ_content(qContent);
    q.setCategory(category);
    q.setTag(tag);
    q.setPrice(0.99);
    q.setCreate_time(curDate);
    boolean flag = questionService.addQuestion(q);
    redisTemplate.opsForValue().set("question"+q.getQid(),q);
    Result result = new Result();
    if(flag) {
      return ResultUtil.qSucc(result,q);
    } else {
      return ResultUtil.error(result);
    }
  }


  @RequestMapping(value={"/update"},method = RequestMethod.POST)
  public Result updateQuestion(@RequestParam("title") String qTitle,
                             @RequestParam("content") String qContent,
                             @RequestParam("qid") Long qid) {
    if(qContent.equals("")  || qid<=0 || qTitle.equals("")) {
      log.error("content empty or qid invalid");
      return ResultUtil.empty(new Result());
    }
    Question question = (Question) redisTemplate.opsForValue().get("question"+qid);
    if(question==null)
      question = questionService.searchOneQuestion(qid);
    if(question==null) {
      return ResultUtil.empty(new Result());
    }
    question.setQ_title(qTitle);
    question.setQ_content(qContent);
    redisTemplate.opsForValue().set("question"+qid,question);
    log.info(question.toString());
    boolean flag = questionService.updateQuestion(question);
    Result result = new Result();
    if(flag) {
      log.info("update succ :)");
      return ResultUtil.qSucc(result,question);
    } else {
      log.error("update failed :(");
      return ResultUtil.error(result);
    }
  }

  @RequestMapping(value={"/search"},method = RequestMethod.GET)
  public Result searchQuestions(@RequestParam("keyword") String keyword) {
   // long size = redisTemplate.opsForList().size(keyword);
  //  List<Question> questions = redisTemplate.opsForList().range(keyword,0,size);
  //  if(questions==null) {
    List<Question>questions = questionService.searchQuestion(keyword);
  //    redisTemplate.opsForList().leftPushAll(keyword,questions);
  //  }

    if(questions!=null) {
      log.info("no similar results");
      return ResultUtil.SearchQuestionSucc(new Result(),questions);
    } else {
      log.info("found something");
      return ResultUtil.error(new Result());
    }
  }

  @RequestMapping(value={"/delete"},method = RequestMethod.DELETE)
  public Result deleteQuestion(@RequestParam("qid") Long qid) {
  //  Question question = (Question) redisTemplate.opsForValue().get("question"+qid);
  //  redisTemplate.delete("quesiton"+qid);
  //  if(question==null)
   //   question = questionService.searchOneQuestion(qid);
   // if(question==null)
   //   return ResultUtil.empty(new Result());
    Question question= questionService.searchOneQuestion(qid);
    boolean result = questionService.deleteQuestion(qid);
    if(result) {
      log.info("delete succ :)");
      return ResultUtil.qSucc(new Result(),question);
    } else {
      log.error("delete failed :(");
      return ResultUtil.error(new Result());
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

  @RequestMapping(value = {"/upload"}, method = RequestMethod.POST)
  public void upload(@RequestParam("file") MultipartFile file) {
    String localPath = "/src/main/resources/images/upload";
    if(FileUtils.upload(file, localPath,file.getOriginalFilename())) {
      log.info("upload succ :)");
    } else {
      log.error("upload failed :(");
    }
  }



}
