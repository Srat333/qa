package com.qingjiao.qa.dao;

import com.qingjiao.qa.entity.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionDao {


  @Insert("INSERT INTO questions(question_uid,q_title,q_content,create_time,pid,category," +
          "tag, price) VALUES(#{questionUid},#{qTitle},#{qContent},#{createTime},#{pid},#{category}," +
          "#{tag},#{price})")
  @Options(useGeneratedKeys = true,keyProperty = "qid",keyColumn = "qid")
  int addQuestion(Question q);

  @Update("UPDATE questions SET q_title=#{q_title},q_content=#{q_content} where qid=#{qid}")
  int updateQuestion(Question question);

  @Delete("DELETE FROM questions WHERE qid=#{qid}")
  int deleteQuestion(Long qid);

  @Select("SELECT * FROM questions WHERE CONCAT (q_title, q_content) LIKE CONCAT('%',#{keyword},'%')")
  List<Question> searchQuestions(@Param("keyword") String keyword);

  @Select("SELECT * FROM questions WHERE qid=#{qid}")
  Question searchOneQuestion(Long qid);

  @Select("SELECT * FROM questions")
  List<Question> listAllQuestion();

  @Delete("DELETE * FROM questions")
  int deleteAllQuestion();



}
