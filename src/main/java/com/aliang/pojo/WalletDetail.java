package com.aliang.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class WalletDetail implements Serializable {
    private Long id;

    /**
    * 用户钱包
    */
    private Integer walletId;

    /**
    * 操作时间
    */
    private Date createTime;

    /**
    * 1 充值 2 消费 3退款
    */
    private Short status;

    /**
    * 金额
    */
    private Integer amount;

    private static final long serialVersionUID = 1L;
}