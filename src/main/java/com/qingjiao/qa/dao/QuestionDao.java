package com.qingjiao.qa.dao;

import com.qingjiao.qa.entity.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionDao {


  @Insert("INSERT INTO questions(question_uid,q_content,create_time,answer_uid,a_content,answer_time," +
          "tag, price) VALUES(#{question_uid},#{q_content},#{create_time},#{answer_uid},#{a_content},#{answer_time}," +
          "#{tag},#{price})")
  int addQuestion(Question q);

  @Update("UPDATE questions SET qContent=#{qContent} where ")
  int updateQuestion(String qContent);

  @Delete("DELETE FROM  questions WHERE qid=#{qid}")
  int deleteQuestion(int qid);

  @Select("SELECT * FROM questions where q_content LIKE CONCAT(%,#{keyword},%)")
  List<Question> searchQuesitons(@Param("keyword") String keyword);

  @Select("SELECT * FROM questions")
  List<Question> listAllQuestion();



}
