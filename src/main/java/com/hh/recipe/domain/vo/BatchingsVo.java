package com.hh.recipe.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "配料VO实体")
public class BatchingsVo {

    @ApiModelProperty("配料名")
    private String batchingName;

    @ApiModelProperty("配料数量")
    private String batchingQuantity;
}
