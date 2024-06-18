package com.hh.recipe.domain.po;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@ApiModel(description = "菜谱分类实体")
public class RecipeCategory {
    @ApiModelProperty("分类ID")
    private Integer categoryId;

    @ApiModelProperty("菜谱ID")
    private Integer recipeId;
}