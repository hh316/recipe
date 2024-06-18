package com.hh.recipe.domain.po;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

@Data
@ApiModel(description = "点赞实体")
public class RecipeLikes {
    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("菜谱ID")
    private Integer recipeId;

    @ApiModelProperty("点赞日期和时间")
    private Timestamp likeDate;
}