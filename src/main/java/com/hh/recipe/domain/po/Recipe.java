package com.hh.recipe.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

@Data
@ApiModel(description = "菜谱实体")
@TableName("Recipe")
public class Recipe {
    @ApiModelProperty("菜谱ID")
    @TableId(type = IdType.AUTO)//必须要加不然无法返回主键id
    private Integer recipeId;

    @ApiModelProperty("菜谱名")
    private String recipeName;

    @ApiModelProperty("菜谱图片")
    private String recipeImage;

    @ApiModelProperty("菜谱简介")
    private String recipeDescription;

    @ApiModelProperty("创建者ID")
    private Integer creatorId;

    @ApiModelProperty("创建时间")
    private Timestamp createTime;
    @ApiModelProperty("菜谱心得")
    private String recipeExperience;

}