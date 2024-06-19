package com.hh.recipe.controller;

import com.hh.recipe.domain.dto.LoginDto;
import com.hh.recipe.domain.po.User;
import com.hh.recipe.service.UserService;
import com.hh.recipe.utils.Result;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//ctrl+alt+L自动代码整理
@RestController
@RequestMapping("/user")
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

    //登录后根据请求头token获取用户信息
    @GetMapping("getUserInfo")
    private Result getUserInfo() {
        Result result = userService.getUserInfo();
        return result;
    }

    //根据用户id查出所有粉丝的头像和名称和id
    @GetMapping("findAllfans")
    private Result findAllfans() {
        Result result = userService.findAllfans();
        return result;
    }

    //根据用户id查出所有关注的头像和名称和id
    @GetMapping("findAllFollower")
    private Result findAllFollower() {
        Result result = userService.findAllFollower();
        return result;
    }
}
