package com.zzs.gmall.service.impl;

import com.zzs.gmall.bean.UserAddress;
import com.zzs.gmall.service.OrderService;
import com.zzs.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 2）、配置服务提供者
 * <p>
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 *
 * @author lfy
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    public void initOrder2(String userId) {
        System.out.println("用户id：" + userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : addressList) {

            System.out.println(userAddress.getUserAddress());
        }

    }

    public List<UserAddress> initOrder(String userId) {
        return null;
    }


}
