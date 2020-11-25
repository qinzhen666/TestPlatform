package com.springbootdemo.spbtdemo.service.impl;

import com.springbootdemo.spbtdemo.dto.UserLoginDto;
import com.springbootdemo.spbtdemo.service.HogwartsTestUserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author : QinZhen
 * @Date : 2020/11/16 9:05 下午
 */
@Service  //@Component
public class HogwartsTestUserServiceImpl implements HogwartsTestUserService {


    @Override
    public String login(UserLoginDto userLoginDto){
        System.out.println(userLoginDto.getName());
        System.out.println(userLoginDto.getPwd());

        return userLoginDto.getName() + " " + userLoginDto.getPwd();

    }

}
