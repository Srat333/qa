package com.qingjiao.qa.service;


import com.qingjiao.qa.entity.Order;
import com.qingjiao.qa.exception.Result;

import java.util.List;

public interface OrderService {

  public boolean addOrder(Long qid,String url);

  public boolean payOrder(Long qid);

  public boolean refund(Long qid);

  public Result searchOrdersByUid(Long uid);



}
