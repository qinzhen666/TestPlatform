package com.springbootdemo.spbtdemo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author : QinZhen
 * @Date : 2020/11/19 1:51 上午
 */
@ApiModel(value = "列表查询的分页参数", description = "请求分页参数")
@Data
public class PageTableRequest<Dto extends BaseDto> implements Serializable {

    private static final long serialVersionUID = -5970040480111644170L;

    @ApiModelProperty(value = "页码",required = true, example = "1")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "每页数据量",required = true, example = "10")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "特定查询参数",required = true, example = "status=1")
    private Dto params;
}
