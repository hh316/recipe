package com.hh.recipe.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hh.recipe.utils.JwtHelper;
import com.hh.recipe.utils.Result;
import com.hh.recipe.utils.ResultCodeEnum;
import com.hh.recipe.utils.TokenContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录包含拦截器
@Component
public class LoginProtectedInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //把token存放到线程池中
        TokenContextHolder.setToken(token);
        boolean expiration = jwtHelper.isExpiration(token);
        if (!expiration) {
            return true;
        }
        Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        response.getWriter().print(json);
        return false;
    }
}
