package com.hh.recipe.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class LoginDto {
    @ApiModelProperty("登录的用户名")
    private String userName;

    @ApiModelProperty("登录的密码")
    private String userPassword;

}
