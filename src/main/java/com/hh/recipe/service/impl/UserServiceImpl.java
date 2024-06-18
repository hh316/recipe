package com.hh.recipe.service.impl;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hh.recipe.domain.dto.LoginDto;
import com.hh.recipe.domain.po.User;
import com.hh.recipe.mapper.UserMapper;
import com.hh.recipe.service.UserService;
import com.hh.recipe.utils.JwtHelper;
import com.hh.recipe.utils.MD5Util;
import com.hh.recipe.utils.Result;
import com.hh.recipe.utils.ResultCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;
    private final JwtHelper jwtHelper;

    //登录功能
    public Result login(LoginDto loginDto) {
        System.out.println(loginDto);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(User::getUserName, loginDto.getUserName());
        User loginUser = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println("查到的登录用户信息:" + loginUser);
        //账号错误
        if (loginUser == null) {
            return Result.build("错误", ResultCodeEnum.USERNAME_ERROR);
        }
        //对比密码
        if (!StringUtils.isEmpty(loginUser.getUserPassword()) && MD5Util.encrypt(loginDto.getUserPassword()).equals(loginUser.getUserPassword())) {
            //登录成功-根据用户的id生成token
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUserId()));
            //将token封装到result返回
            HashMap data = new HashMap();
            data.put("token", token);
            return Result.ok(data);
        }
        //密码错误
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    /**
     * @param user
     * @return
     */
    @Override
    //注册功能
    public Result register(User user) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUserName, user.getUserName());
        Long count = Long.valueOf(userMapper.selectCount(userLambdaQueryWrapper));
        if (count > 0) {
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        //给密码加密
        user.setUserPassword(MD5Util.encrypt(user.getUserPassword()));
        //保存用户
        userMapper.insert(user);
        return Result.ok(null);

    }
}
