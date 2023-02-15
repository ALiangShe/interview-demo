package com.aliang.param;

import lombok.Data;

@Data
public class AmountParam {
    private Integer userId;
    private Integer amount;

    private Short status;
}
