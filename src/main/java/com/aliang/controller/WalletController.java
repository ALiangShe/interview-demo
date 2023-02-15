package com.aliang.controller;

import com.aliang.Service.WalletDetailService;
import com.aliang.common.Result;
import com.aliang.param.AmountParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletDetailService walletDetailService;


    @GetMapping("/list/{id}")
    public Result getWalletDetailList(@PathVariable("id")Long id){
        return walletDetailService.getWalletDetailList(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody AmountParam amountParam){
        return walletDetailService.update(amountParam);
    }
}
