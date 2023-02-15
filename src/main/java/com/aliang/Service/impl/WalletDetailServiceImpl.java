package com.aliang.Service.impl;

import com.aliang.Mapper.UserMapper;
import com.aliang.Mapper.WalletDetailMapper;
import com.aliang.Service.WalletDetailService;
import com.aliang.common.Result;
import com.aliang.param.AmountParam;
import com.aliang.pojo.User;
import com.aliang.pojo.WalletDetail;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WalletDetailServiceImpl implements WalletDetailService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WalletDetailMapper walletDetailMapper;


    @Override
    public Result getWalletDetailList(Long id) {
        User user = userMapper.selectById(id);
        if (user == null){
            return Result.error("用户不存在");
        }
        List<WalletDetail> walletDetailList = walletDetailMapper.selectList(Wrappers.<WalletDetail>lambdaQuery().eq(WalletDetail::getWalletId, user.getWalletId()));
        return Result.success(walletDetailList);
    }

    @Override
    public Result update(AmountParam amountParam) {
        User user = userMapper.selectById(amountParam.getUserId());
        if (user == null){
            return Result.error("用户不存在");
        }
        WalletDetail walletDetail = new WalletDetail();
        if (amountParam.getStatus() == 2){
            if (amountParam.getAmount() > user.getBalance()){
                return Result.error("当前用户余额不足");
            }
            walletDetail.setStatus((short) 2);
            user.setBalance(user.getBalance() - amountParam.getAmount());
        }else if (amountParam.getStatus() == 3){
            walletDetail.setStatus((short) 3);
            user.setBalance(user.getBalance() + amountParam.getAmount());
        }
        userMapper.updateById(user);
        walletDetail.setWalletId(user.getWalletId());
        walletDetail.setAmount(amountParam.getAmount());
        walletDetail.setCreateTime(new Date());
        walletDetailMapper.insert(walletDetail);
        return Result.success("操作成功！");
    }
}
