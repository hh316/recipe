package com.hh.recipe.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hh.recipe.domain.po.Batchings;
import com.hh.recipe.domain.po.Category;
import com.hh.recipe.domain.po.CookingStep;
import com.hh.recipe.domain.po.Ingredients;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@ApiModel(description = "菜谱信息VO实体")
public class RecipeDetailVo {

    @ApiModelProperty("菜谱名")
    private String recipeName;

    @ApiModelProperty("菜谱图片")
    private String recipeImage;

    @ApiModelProperty("菜谱简介")
    private String recipeDescription;

    @ApiModelProperty("创建时间")
    private Timestamp createTime;
    @ApiModelProperty("菜谱心得")
    private String recipeExperience;

}