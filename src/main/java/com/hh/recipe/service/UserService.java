package com.hh.recipe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hh.recipe.domain.dto.LoginDto;
import com.hh.recipe.domain.dto.UserDto;
import com.hh.recipe.domain.po.User;
import com.hh.recipe.utils.Result;

public interface UserService extends IService<User> {

    Result login(LoginDto loginDto);

    Result register(UserDto userDto);

    Result getUserInfo();

    Result findAllfans();

    Result findAllFollower();

    Result likeRecipe(int recipeId);

    Result favoritesRecipe(int recipeId);
}
