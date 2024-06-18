package com.hh.recipe.domain.dto;

import com.hh.recipe.domain.po.Batchings;
import com.hh.recipe.domain.po.Category;
import com.hh.recipe.domain.po.CookingStep;
import com.hh.recipe.domain.po.Ingredients;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@Data
@ApiModel(description = "菜谱DTO实体")
public class CreateRecipeDto {
//    @ApiModelProperty("菜谱ID")
//    private Integer recipeId;

    @ApiModelProperty("菜谱名")
    private String recipeName;

    @ApiModelProperty("菜谱图片")
    private String recipeImage;

    @ApiModelProperty("菜谱简介")
    private String recipeDescription;

    @ApiModelProperty("创建者ID")
    private Integer creatorId;

    @ApiModelProperty("菜谱心得")
    private String recipeExperience;

    @ApiModelProperty("食材列表")
    private List<Ingredients> ingredients;

    @ApiModelProperty("配料列表")
    private List<Batchings> batchings;

    @ApiModelProperty("烹饪步骤列表")
    private List<CookingStep> cookingSteps;

    @ApiModelProperty("分类列表")
    private List<Category> categories;
}