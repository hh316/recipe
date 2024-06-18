package com.hh.recipe.domain.po;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

@Data
@ApiModel(description = "收藏实体")
public class RecipeFavorites {
    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("菜谱ID")
    private Integer recipeId;

    @ApiModelProperty("收藏日期和时间")
    private Timestamp favoriteDate;
}