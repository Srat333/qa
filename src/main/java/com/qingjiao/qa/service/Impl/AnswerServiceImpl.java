package com.qingjiao.qa.service.Impl;

import com.qingjiao.qa.dao.AnswerDao;
import com.qingjiao.qa.entity.Answer;
import com.qingjiao.qa.exception.Result;
import com.qingjiao.qa.service.AnswerService;
import com.qingjiao.qa.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;


@Slf4j
@Service
public class AnswerServiceImpl implements AnswerService {

  @Autowired
  private AnswerDao answerDao;


  @Autowired
  private RedisTemplate redisTemplate;


  @Override
  public Result addAnswer(Long qid, String aContent) {
    if(aContent.equals("") || aContent==null) {
      log.error("answer is empty :(");
      return ResultUtil.empty(new Result());
    }
    Answer answer = new Answer();
    answer.setAnswerUid(222L);
    Date date = new Date();
    answer.setAnswerTime(date);
    answer.setAContent(aContent);
    answer.setQid(qid);
    redisTemplate.opsForValue().set("answer"+answer.getAid(),answer);
    log.info("saved in redis answer"+" "+answer.getAid());
    int index = answerDao.addAnswer(answer);
    Result result = new Result();
    if(index>0) {
      return ResultUtil.succ(result,answer,"answer");
    } else {
      return ResultUtil.error(result);
    }
  }


  @Override
  public Result updateAnswer(String content,Long aid) {
    if(content.equals("") || content==null) {
      log.error("re-answer is empty :(");
      return ResultUtil.empty(new Result());
    }
    Answer answer = (Answer)redisTemplate.opsForValue().get("answer"+aid);
    if(answer==null)
      answer = searchOneAnswer(aid);
    answer.setAContent(content);
    int index = answerDao.updateAnswer(answer);
    redisTemplate.opsForValue().set("answer"+aid,answer);
    Result result = new Result();
    if(index>0) {
      return ResultUtil.succ(result,answer,"re-reply");
    } else {
      return ResultUtil.error(result);
    }

  }


  @Override
  public Result comment(String comment,Long aid,double score) {
    if(comment.equals("") || comment==null || score<0.0 || score>5.0) {
      log.error("comment or score are none or out of scope");
      return ResultUtil.empty(new Result());
    }
    Answer answer = (Answer)redisTemplate.opsForValue().get("answer"+aid);
    if(answer==null)
      answer = searchOneAnswer(aid);
    if(answer==null)
      return ResultUtil.empty(new Result());
    answer.setComment(comment);
    answer.setScore(score);
    int index = answerDao.comment(answer);
    redisTemplate.opsForValue().set("answer"+answer.getAid(),answer);
    Result result = new Result();
    if(index>0) {
      return ResultUtil.succ(result,answer,"comment");
    } else {
      return ResultUtil.error(result);
    }

  }

  @Override
  public Result deleteAnswer(Long aid) {

    Answer answer = (Answer)redisTemplate.opsForValue().get("answer"+aid);
    if(StringUtils.isEmpty(answer))
      answer = searchOneAnswer(aid);
    if(StringUtils.isEmpty(answer))
      return ResultUtil.empty(new Result());
    log.info(answer.toString());

    int index = answerDao.deleteAnswer(aid);
    //log.info(String.valueOf(result));
    log.info(String.valueOf(index));
    redisTemplate.delete("answer"+aid);
    Result result = new Result();
    if(index>0) {
      return ResultUtil.succ(result,null,"delete");
    } else {
      return ResultUtil.error(result);
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
