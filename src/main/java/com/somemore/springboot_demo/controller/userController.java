package com.somemore.springboot_demo.controller;

import com.somemore.springboot_demo.pojo.ResponseMessage;
import com.somemore.springboot_demo.pojo.User;
import com.somemore.springboot_demo.pojo.dto.UserDto;
import com.somemore.springboot_demo.service.IUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController // 接口方法返回对象 转换成json文本
@RequestMapping("/user")
public class userController {

    @Autowired
    private IUserservice userservice;

    // 增加
    @PostMapping   // URL: localhost:808/user  metch:post
    public ResponseMessage<User> addUser(@Validated @RequestBody UserDto user)
    {
        User newUser = userservice.add(user);
        return ResponseMessage.success(newUser);
    }

    // 查询
    @GetMapping("/{userId}")
    public ResponseMessage<User> queryUser(@PathVariable Integer userId)
    {
        User newUser = userservice.getUser(userId);
        return ResponseMessage.success(newUser);
    }
    // 删除
    // @DeleteMapping

    // 修改
    // @PutMapping

}
