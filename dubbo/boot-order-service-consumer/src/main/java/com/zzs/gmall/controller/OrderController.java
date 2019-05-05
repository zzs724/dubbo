package com.zzs.gmall.controller;

import com.zzs.gmall.bean.UserAddress;
import com.zzs.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

//http://localhost:8081/initOrder/haha?id=1
    @RequestMapping("/initOrder/{name}")
    public List<UserAddress> initOrder(@PathVariable("name")String name, @RequestParam("id")String userId) {
        System.out.println(name);
        System.out.println(userId);
        return  orderService.initOrder(userId);

    }





















}
