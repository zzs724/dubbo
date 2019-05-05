package com.zzs.gmall.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zzs.gmall.bean.UserAddress;
import com.zzs.gmall.service.OrderService;
import com.zzs.gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 2）、配置服务提供者
 * <p>
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 *
 * @author zzs
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Reference//代替Autowired
    UserService userService;

    @Override
    public void initOrder2(String userId) {

    }

    @HystrixCommand(fallbackMethod = "hello")
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id：" + userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        return addressList;

    }

    public List<UserAddress> hello(String userId) {

        List<UserAddress> addressList = new ArrayList<UserAddress>();
        addressList.add(new UserAddress(1,"霍营","2","root","110","Y"));
        return addressList;

    }


}
