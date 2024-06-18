package com.hh.recipe.domain.po;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

@Data
@ApiModel(description = "关注实体")
public class UserFollows {
    @ApiModelProperty("关注者ID")
    private Integer followerId;

    @ApiModelProperty("被关注者ID")
    private Integer followeeId;

    @ApiModelProperty("关注日期和时间")
    private Timestamp followDate;
}