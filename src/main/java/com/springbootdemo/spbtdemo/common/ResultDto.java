package com.springbootdemo.spbtdemo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 响应大对象
 * @Author : QinZhen
 * @Date : 2020/11/19 1:15 上午
 */
@ApiModel(value = "基础返回类",description = "基础返回类")
public class ResultDto<T> implements Serializable {

    private static final long serialVersionUID = 7760280277429265664L;

    @ApiModelProperty(value = "返回结果码1成功，0失败", required = true, example = "1", allowableValues = "1,0")
    private Integer resultCode;

    @ApiModelProperty(value = "提示信息", example = "成功", allowableValues = "成功,失败")
    private String message = "";

    @ApiModelProperty(value = "响应结果数据")
    private T data = null;

    public Integer getResultCode(){
        return resultCode;
    }

    public static ResultDto newInstance(){
        return new ResultDto();
    }


    /**
     * 设置为成功状态
     */
    public void setAsSuccess(){
        this.resultCode = 1;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public static ResultDto success(String message){
        ResultDto resultDto = new ResultDto();
        resultDto.setAsSuccess();
        resultDto.setMessage(message);
        return resultDto;
    }

    public static <T> ResultDto<T> success(String message,T data){
        ResultDto<T> resultDto = new ResultDto<>();
        resultDto.setAsSuccess();
        resultDto.setMessage(message);
        resultDto.setData(data);
        return resultDto;
    }

    /**
     * 设置为失败状态
     * @return
     */
    public void setAsFail(){
        this.resultCode = 0;
    }

    public static <T> ResultDto<T> fail(String message){
        ResultDto<T> resultDto = new ResultDto<>();
        resultDto.setAsFail();
        resultDto.setMessage(message);
        return resultDto;
    }

    public static <T> ResultDto<T> fail(String message, T data){
        ResultDto<T> resultDto = new ResultDto<>();
        resultDto.setAsFail();
        resultDto.setMessage(message);
        resultDto.setData(data);
        return resultDto;
    }


    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }


}
