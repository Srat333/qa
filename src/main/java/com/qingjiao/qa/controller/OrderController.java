package com.qingjiao.qa.controller;


import com.qingjiao.qa.exception.Result;
import com.qingjiao.qa.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @RequestMapping(value = "/add",method = RequestMethod.POST)
  public void addOrder(@RequestParam("qid") Long qid) {
    orderService.addOrder(qid,"");
  }

  @RequestMapping(value = "/pay",method = RequestMethod.POST)
  public void payOrder(@RequestParam("qid") Long qid) {
    orderService.payOrder(qid);
  }

  @RequestMapping(value = "/refund",method = RequestMethod.POST)
  public void refund(@RequestParam("qid") Long qid) {
    orderService.refund(qid);
  }

  @RequestMapping(value = "/comment",method = RequestMethod.POST)
  public void comment(@RequestParam("comment") String comment) {

  }

  @RequestMapping(value = "/usr",method = RequestMethod.GET)
  public Result searchOrdersByUid(@PathVariable("uid") Long uid) {
    return orderService.searchOrdersByUid(uid);
  }



}
