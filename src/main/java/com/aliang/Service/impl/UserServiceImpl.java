package com.aliang.Service.impl;

import com.aliang.Mapper.UserMapper;
import com.aliang.Service.UserService;
import com.aliang.common.Result;
import com.aliang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result getBalance(Long id) {
        User user = userMapper.selectById(id);
        if (user == null){
            return Result.error("用户不存在");
        }
        return Result.success(user.getBalance());
    }
}
