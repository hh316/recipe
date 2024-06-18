package com.hh.recipe.domain.po;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@ApiModel(description = "烹饪步骤实体")
public class CookingStep {
    @ApiModelProperty("步骤ID")
    private Integer stepId;

    @ApiModelProperty("菜谱ID")
    private Integer recipeId;

    @ApiModelProperty("步骤顺序")
    private Integer stepOrder;

    @ApiModelProperty("步骤描述")
    private String stepDescription;

    @ApiModelProperty("步骤图片URL")
    private String stepImageUrl;
}