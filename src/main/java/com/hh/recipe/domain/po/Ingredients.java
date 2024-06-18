package com.hh.recipe.domain.po;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@ApiModel(description = "食材实体")
@TableName("Ingredients")//别名
public class Ingredients {
    @ApiModelProperty("食材ID")
    private Integer ingredientId;

    @ApiModelProperty("食材名")
    private String ingredientName;

    @ApiModelProperty("食材数量")
    private String ingredientQuantity;

    @ApiModelProperty("菜谱ID")
    private Integer recipeId;
}