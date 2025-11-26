package com.somemore.springboot_demo.service;

import com.somemore.springboot_demo.pojo.User;
import com.somemore.springboot_demo.pojo.dto.UserDto;

public interface IUserservice {
    /**
     * 插入用户
     * @param user 参数
     */
    User add(UserDto user);

    /**
     * 查询用户
     * @param user 参数
     * @return
     */
    User getUser(Integer id);
}
