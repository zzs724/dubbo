package com.zzs.gmall.service;

import com.zzs.gmall.bean.UserAddress;

import java.util.List;

public interface OrderService {
    public void initOrder2(String userId);
    public List<UserAddress> initOrder(String userId);
}
