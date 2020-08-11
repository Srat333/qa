package com.qingjiao.qa.service;


import com.qingjiao.qa.entity.Order;
import com.qingjiao.qa.exception.Result;

import java.util.List;

public interface OrderService {

  Result addOrder(Long qid,String url);

  Result payOrder(Long qid);

  Result refund(Long qid);

  Result searchOrdersByQid(Long qid);



}
