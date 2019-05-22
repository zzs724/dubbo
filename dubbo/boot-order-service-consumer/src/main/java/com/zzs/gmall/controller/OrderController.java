package com.zzs.gmall.controller;

import com.alibaba.fastjson.JSONObject;
import com.zzs.gmall.bean.UserAddress;
import com.zzs.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

//    @Autowired
    OrderService orderService;

//http://localhost:8081/initOrder/haha?id=1
    @RequestMapping("/initOrder/{name}")
    public List<UserAddress> initOrder(@PathVariable("name")String name, @RequestParam("id")String userId) {
        System.out.println(name);
        System.out.println(userId);
        return  orderService.initOrder(userId);

    }

    @PostMapping("/test")
    public void test(@RequestBody User user){
        System.out.println(11111111);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.toString());
    }
/*    {
        "name":"zzs",
            "id":"2222",
            "aClass":{
                "className":"1",
                "classId":2222
            }
    }*/
    @PostMapping("/test2")
    public void test2(@RequestBody JSONObject jsonObject){
        System.out.println(11111111);
        System.out.println(jsonObject.toString());
        User user = JSONObject.toJavaObject(jsonObject, User.class);
        System.out.println(user.toString());
    }













static class User{
        String name;
        String id;

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    Class aClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", aClass=" + aClass +
                '}';
    }
}

static class Class{
        String className;
        int classId;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Class() {
    }

    @Override
    public String toString() {
        return "Class{" +
                "className='" + className + '\'' +
                ", classId=" + classId +
                '}';
    }
}


}
