package com.hh.recipe.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
@ApiModel(description = "用户实体VO")
public class UserVo {
    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("用户名")
    @Column(unique = true)//设置成唯一不可重复  JPA里的注解
    private String userName;

    @ApiModelProperty("用户头像")
    private String userAvatar;
}