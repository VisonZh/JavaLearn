package com.somemore.springboot_demo.service;

import com.somemore.springboot_demo.pojo.User;
import com.somemore.springboot_demo.pojo.dto.UserDto;
import com.somemore.springboot_demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.PortUnreachableException;

@Service    // spring 的 bean
public class Userservice implements IUserservice {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDto user) {

        User userPojo = new User();
        BeanUtils.copyProperties(user,userPojo);

        return userRepository.save(userPojo);

    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在，参数异常！");
        });

    }
}
