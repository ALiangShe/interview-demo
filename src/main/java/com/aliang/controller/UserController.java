package com.aliang.controller;

import com.aliang.Service.UserService;
import com.aliang.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户钱包余额
     * @param id
     * @return
     */
    @GetMapping("/balance/{id}")
    public Result getBalance(@PathVariable("id")Long id){
        return userService.getBalance(id);
    }
}
