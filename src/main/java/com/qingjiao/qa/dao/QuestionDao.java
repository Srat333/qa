package com.qingjiao.qa.dao;

import com.qingjiao.qa.entity.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionDao {


  @Insert("INSERT INTO questions(question_uid,q_content,create_time,answer_uid,a_content,answer_time," +
          "tag, price) VALUES(#{question_uid},#{q_content},#{create_time},#{answer_uid},#{a_content},#{answer_time}," +
          "#{tag},#{price})")
  int addQuestion(Question q);

  @Update("UPDATE questions SET q_content=#{qContent} where qid=#{qid}")
  int updateQuestion(String qContent, Long qid);

  @Delete("DELETE FROM  questions WHERE qid=#{qid}")
  int deleteQuestion(Long qid);

  @Select("SELECT * FROM questions where q_content LIKE CONCAT('%',#{keyword},'%')")
  List<Question> searchQuestions(@Param("keyword") String keyword);

  @Select("SELECT * FROM questions where qid=#{qid}")
  Question searchOneQuestion(@Param("qid") Long qid);

  @Select("SELECT * FROM questions")
  List<Question> listAllQuestion();



}
