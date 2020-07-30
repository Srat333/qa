package com.qingjiao.qa.service;


import com.qingjiao.qa.dao.OrderDao;
import com.qingjiao.qa.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Service
public class OrderService {

  @Resource
  private OrderDao orderDao;

  public boolean addOrder(Long qid,String url) {
    Date cur = new Date();
    Order order = new Order();
    order.setQid(qid);
    order.setOrder_time(cur);
    int result = orderDao.addOrder(order);
    if(result<0) {
      log.error("add order failure :(");
      return false;
    } else {
      log.info("add order succ :)");
      return true;
    }
  }

  public boolean payOrder(Long qid) {
    if(orderDao.searchOrderByQid(qid)==null) {
      log.error("question is not existed");
      return false;
    }
    Date cur = new Date();
    int result = orderDao.payOrder(qid,1,cur);
    if(result<0) {
      log.error("pay order failure :(");
      return false;
    } else {
      log.info("pay order succ :)");
      return true;
    }
  }

  public boolean refund(Long qid) {
    if(orderDao.searchOrderByQid(qid)==null) {
      log.error("question is not existed");
      return false;
    }
    int result = orderDao.refundOrder(qid,1);
    if(result<0) {
      log.error("refund failure :(");
      return false;
    } else {
      log.info("refund succ :)");
      return true;
    }
  }





}
