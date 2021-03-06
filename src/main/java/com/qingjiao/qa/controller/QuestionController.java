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

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/qa")
public class QuestionController {

  @Resource
  private QuestionService questionService;

  @RequestMapping(value={"/add"},method = RequestMethod.POST)

  public Result addQuestion(@RequestParam("title") String qTitle,
                            @RequestParam("content") String qContent,
                            @RequestParam("category") String category,
                            @RequestParam("tag") String tag,
                            @RequestParam("uid") String uid) {
    return questionService.addQuestion(qContent,tag,qTitle,category,uid);
  }


  @RequestMapping(value={"/update"},method = RequestMethod.POST)
  public Result updateQuestion(@RequestParam("title") String qTitle,
                             @RequestParam("content") String qContent,
                             @RequestParam("qid") Long qid) {
    return questionService.updateQuestion(qContent,qid,qTitle);
  }

  @RequestMapping(value={"/search"},method = RequestMethod.GET)
  public Result searchQuestions(@RequestParam("keyword") String keyword) {
   return questionService.searchQuestions(keyword);
  }

  @RequestMapping(value={"/delete"},method = RequestMethod.DELETE)
  public Result deleteQuestion(@RequestParam("qid") Long qid) {
    return questionService.deleteQuestion(qid);
  }

  @RequestMapping(value={"/all"},method = RequestMethod.GET)
  public Result listAllQuestions() {
    Result result = questionService.listAllQuestions();
    if(result!=null) {
      log.info("list all successfully!!!!");
      return result;
    } else {
      log.error("list add :(");
      return null;
    }
  }

  @RequestMapping(value={"/user_q"},method = RequestMethod.GET)
  public Result searchQuestionsByUid(@RequestParam("uid") String uid) {
    return questionService.searchQuestionsByUid(uid);
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

  @RequestMapping(value = {"/searchAudits"},method = RequestMethod.POST)
  public Result searchAuditsByQid(@RequestParam("qid") Long qid) {
    return questionService.searchAuditsByQid(qid);
  }

  @RequestMapping(value = {"/updateAudits"},method = RequestMethod.POST)
  public Result updateAuditsByQid(@RequestParam("qid") Long qid,
                                  @RequestParam("uid") String uid) {
    return questionService.updateAuditsByQid(qid,uid);
  }


}
