package com.hh.recipe.domain.po;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;

@Data
@ApiModel(description = "用户实体")
public class User {
    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("用户名")
    @Column(unique = true)//设置成唯一不可重复  JPA里的注解
    private String userName;

    @ApiModelProperty("密码")
    private String userPassword;

    @ApiModelProperty("用户头像")
    private String userAvatar;
}