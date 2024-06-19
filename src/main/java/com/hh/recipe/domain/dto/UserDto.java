package com.hh.recipe.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
@ApiModel(description = "用户注册实体")
@TableName("User")
public class UserDto {

    @ApiModelProperty("用户名")
    @Column(unique = true)//设置成唯一不可重复  JPA里的注解
    private String userName;

    @ApiModelProperty("密码")
    private String userPassword;

    @ApiModelProperty("用户头像")
    private String userAvatar;
}