package com.hh.recipe.domain.po;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@ApiModel(description = "配料实体")
public class Batchings {
    @ApiModelProperty("配料ID")
    private Integer batchingId;

    @ApiModelProperty("配料名")
    private String batchingName;

    @ApiModelProperty("配料数量")
    private String batchingQuantity;

    @ApiModelProperty("菜谱ID")
    private Integer recipeId;

}