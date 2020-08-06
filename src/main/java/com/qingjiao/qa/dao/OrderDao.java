package com.qingjiao.qa.dao;


import com.qingjiao.qa.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface OrderDao {

  @Insert("INSERT INTO orders(qid,aid,url,is_paid,is_answered,is_commented,order_time,paid_time,refund)" +
          "VALUES(#{qid},#{aid},#{url},#{is_paid},#{is_answered},#{is_commented},#{order_time},#{paid_time},#{refund})")
  int addOrder(Order order);

  @Update("UPDATE orders SET is_paid=#{is_paid}, paid_time=#{paid_time} WHERE qid = #{qid}")
  int payOrder(Long qid, int is_paid, Date paid_time);

  @Update("UPDATE orders SET refund=#{refund} WHERE qid = #{qid}")
  int refundOrder(Long qid, int refund);

  @Update("UPDATE orders SET aid=#{aid} WHERE qid = #{qid}")
  int comment(Long qid);

  @Select("SELECT * FROM orders WHERE qid = #{qid}")
  Order searchOrderByQid(Long qid);

  @Select("SELECT * FROM orders WHERE uid =#{uid}")
  List<Order> searchOrdersByUid(Long uid);

  @Select("SELECT * FROM orders")
  List<Order> getAllOrder();




}
