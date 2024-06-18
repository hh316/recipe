package com.hh.recipe.domain.po;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@ApiModel(description = "分类实体")
public class Category {
    @ApiModelProperty("分类ID")
    private Integer categoryId;

    @ApiModelProperty("分类名")
    private String categoryName;
    @ApiModelProperty("菜谱ID")
    private Integer recipeId;

}