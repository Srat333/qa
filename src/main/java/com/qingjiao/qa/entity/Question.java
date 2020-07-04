/**
 * qId: 问题id
 * questionUid: 提问者id
 * qContent: 问题描述
 * createTime: 问题创建时间
 * pid: 图片URL
 * category: 目录
 * tag: 问题标签
 * price: 价格
 *
 */
package com.qingjiao.qa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class Question implements Serializable {

  private Long qid;

  private Long question_uid;

  private String q_title;

  private String q_content;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date create_time;

  private String pid;

  private String category;

  private String tag;

  private double price;




}
