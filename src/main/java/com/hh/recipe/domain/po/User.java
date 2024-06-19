package com.hh.recipe.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;

@Data
@ApiModel(description = "用户实体")
@TableName("User")
public class User {
    @ApiModelProperty("用户ID")
    @TableId("user_id")
    private Integer userId;

    @ApiModelProperty("用户名")
    @Column(unique = true)//设置成唯一不可重复  JPA里的注解
    private String userName;

    @ApiModelProperty("密码")
    private String userPassword;

    @ApiModelProperty("用户头像")
    private String userAvatar;
}