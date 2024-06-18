package com.hh.recipe.controller;

import com.hh.recipe.domain.dto.LoginDto;
import com.hh.recipe.domain.po.User;
import com.hh.recipe.service.UserService;
import com.hh.recipe.utils.Result;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//ctrl+alt+L自动代码整理
@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //登录功能
    @PostMapping("login")
    public Result login(@RequestBody LoginDto loginDto) {
        Result result = userService.login(loginDto);
        return result;
    }

    //注册功能
    //注册功能
    @PostMapping("regist")
    private Result register(@RequestBody User user) {
        Result result = userService.register(user);
        return result;
    }
}
