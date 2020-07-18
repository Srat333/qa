/**
 * aid: 回答id
 * qid: 问题id
 * answer_uid: 回答者id
 * a_content: 回答内容
 * pid: 图片id
 * answer_time: 回答时间
 * score: 得分
 * comment: 评价
 *
 */

package com.qingjiao.qa.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Answer implements Serializable {

  private Long aid;

  private Long qid;

  private Long answer_uid;

  private String a_content;

  private String pid;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date answer_time;

  private Double score;

  private String comment;


}
