package com.springbootdemo.spbtdemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author : QinZhen
 * @Date : 2020/11/16
 */

@ApiModel(value = "用户登录类",description = "请求参数类")
@Data
public class UserLoginDto {

    @ApiModelProperty(value = "用户名",example = "qinzhen", required = true)
    private String name;

    @ApiModelProperty(value = "登录密码", example = "123", required = true)
    private String pwd;


}
