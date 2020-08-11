package com.qingjiao.qa.controller;


import com.qingjiao.qa.exception.Result;
import com.qingjiao.qa.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

  @Resource
  private OrderService orderService;

  @RequestMapping(value = "/add",method = RequestMethod.POST)
  public Result addOrder(@RequestParam("qid") Long qid) {
    return orderService.addOrder(qid,"");
  }

  @RequestMapping(value = "/pay",method = RequestMethod.POST)
  public Result payOrder(@RequestParam("qid") Long qid) {
    return orderService.payOrder(qid);
  }

  @RequestMapping(value = "/refund",method = RequestMethod.POST)
  public Result refund(@RequestParam("qid") Long qid) {
    return orderService.refund(qid);
  }

  @RequestMapping(value = "/usr",method = RequestMethod.GET)
  public Result searchOrdersByQid(@RequestParam("qid") Long qid) {
    return orderService.searchOrdersByQid(qid);
  }



}
