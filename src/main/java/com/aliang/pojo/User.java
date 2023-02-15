package com.aliang.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    /**
    * 主键
    */
    private Long id;

    /**
    * 用户名
    */
    private String username;

    /**
    * 用户钱包
    */
    private Integer walletId;

    /**
    * 钱包余额 默认000 1元 = 100
    */
    private Integer balance;

    private static final long serialVersionUID = 1L;
}