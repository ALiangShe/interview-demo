package com.aliang.Service;

import com.aliang.common.Result;
import com.aliang.param.AmountParam;

public interface WalletDetailService {


    Result getWalletDetailList(Long id);

    Result update(AmountParam amountParam);
}

