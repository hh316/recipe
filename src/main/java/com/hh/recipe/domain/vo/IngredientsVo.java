package com.hh.recipe.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "食材VO实体")
public class IngredientsVo {
    @ApiModelProperty("食材名")
    private String ingredientName;

    @ApiModelProperty("食材数量")
    private String ingredientQuantity;

}
