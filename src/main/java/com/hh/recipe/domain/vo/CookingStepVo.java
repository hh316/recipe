package com.hh.recipe.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "做菜步骤VO实体")
public class CookingStepVo {

    @ApiModelProperty("步骤顺序")
    private Integer stepOrder;

    @ApiModelProperty("步骤描述")
    private String stepDescription;

    @ApiModelProperty("步骤图片URL")
    private String stepImageUrl;
}
