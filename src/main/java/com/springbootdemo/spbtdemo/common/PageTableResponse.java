package com.springbootdemo.spbtdemo.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author : QinZhen
 * @Date : 2020/11/19 1:57 上午
 */
@Data
public class PageTableResponse<T> implements Serializable {

    private static final long serialVersionUID = 5742594754077719174L;

    private Integer recordsTotal;
    private List<T> data;
}
