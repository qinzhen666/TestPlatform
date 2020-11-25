package com.springbootdemo.spbtdemo.controller;


import com.springbootdemo.spbtdemo.common.ResultDto;
import com.springbootdemo.spbtdemo.common.ServiceException;
import com.springbootdemo.spbtdemo.dto.UserLoginDto;
import com.springbootdemo.spbtdemo.service.HogwartsTestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@Api(tags = "仙道测试-测试任务管理")
@RestController
@Slf4j
@RequestMapping("hogwartsTestUser")
public class HogwartsTestUserController {

    @Autowired
    private HogwartsTestUserService hogwartsTestUserService;

    @Value("${hogwarts.key1}")
    private String hogwartsKey1;

//    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ApiOperation("登录接口")
    @PostMapping("login")
    public ResultDto<UserLoginDto> login(@RequestBody UserLoginDto  userLoginDto){

        String result = hogwartsTestUserService.login(userLoginDto);

            if (userLoginDto.getName().contains("error2")){
                throw new NullPointerException();
            }
            if (userLoginDto.getName().contains("error")){
                ServiceException.throwEx("用户名中存在error");
            }
        return ResultDto.success("login success" + result + " " + "hogwartsKey1" + " " + hogwartsKey1, userLoginDto);
    }

    @DeleteMapping("delete")
    public String delete(@RequestBody UserLoginDto userLoginDto){

        System.out.println(userLoginDto.getName());
        System.out.println(userLoginDto.getPwd());
        return "login success";
    }

    @RequestMapping(value = "byId/{userId}/{id}",method = RequestMethod.GET)
    public String getById(@PathVariable("userId") Long userId,@PathVariable("id") Long id){

        System.out.println("userId" + userId);
        System.out.println("id" + id);
        return "get success " + userId + " " + id ;
    }

    @GetMapping(value = "byId")
    public String getById2(@RequestParam(value = "userId",required = false) Long userId,@RequestParam("id") Long id){

        System.out.println("RequestParamuserId" + userId);
        System.out.println("RequestParamid" + id);
        return "get success " + userId + " " + id ;
    }

}
