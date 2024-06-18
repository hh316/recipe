package com.hh.recipe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hh.recipe.domain.dto.LoginDto;
import com.hh.recipe.domain.po.User;
import com.hh.recipe.utils.Result;

public interface UserService extends IService<User> {

    Result login(LoginDto loginDto);

    Result register(User user);

    Integer getUserInfo(String token);
}
