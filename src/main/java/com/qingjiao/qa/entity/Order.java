package com.qingjiao.qa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class Order implements Serializable {

  private Long oid;

  private Long qid;

  private Long aid;

  private String url;

  private int is_paid;

  private int is_answered;

  private int is_commented;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date order_time;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date paid_time;

  private int refund;


}
