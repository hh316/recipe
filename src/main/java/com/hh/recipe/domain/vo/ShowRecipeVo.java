package com.hh.recipe.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("展示菜谱VO")
@ApiModel(description = "展示菜谱VO")
public class ShowRecipeVo {
    @ApiModelProperty("菜谱名")
    private String recipeName;

    @ApiModelProperty("菜谱图片")
    private String recipeImage;

    @ApiModelProperty("菜谱id")
    private Integer recipeId;


}
