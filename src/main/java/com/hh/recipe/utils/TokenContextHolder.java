package com.hh.recipe.utils;
//线程池

public class TokenContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setToken(String token) {
        contextHolder.set(token);
    }

    public static String getToken() {
        return contextHolder.get();
    }

    public static void clearToken() {
        contextHolder.remove();
    }
}