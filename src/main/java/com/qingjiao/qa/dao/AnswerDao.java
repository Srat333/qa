package com.qingjiao.qa.dao;


import com.qingjiao.qa.entity.Answer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AnswerDao {

  @Insert("INSERT INTO answers(qid,answer_uid,a_content,pid,answer_time,score,comment)" +
  "VALUES(#{qid},#{answerUid},#{aContent},#{pid},#{answerTime},#{score},#{comment})")
  int addAnswer(Answer a);

  @Update("UPDATE answers SET a_content=#{aContent} WHERE aid = #{aid}")
  int updateAnswer(Answer a);


  @Update("UPDATE answers SET comment=#{comment},score = #{score} WHERE aid = #{aid}")
  int comment(Answer a);

  @Delete("DELETE FROM answers WHERE aid = #{aid}")
  int deleteAnswer(Long aid);

  @Select("SELECT * FROM answers WHERE qid = #{qid}")
  Answer searchOneQuestion(Long qid);

  @Select("SELECT * FROM answers WHERE aid = #{aid}")
  Answer searchOneAnswer(Long aid);


  @Delete("DELETE * FROM answers")
  int deleteAllAnswers();


}
