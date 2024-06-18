package com.hh.recipe.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hh.recipe.domain.dto.CreateRecipeDto;
import com.hh.recipe.domain.po.Recipe;
import com.hh.recipe.utils.Result;


public interface RecipeService extends IService<Recipe> {
    Result create(CreateRecipeDto recipeDto);

    Result readRecipe();

    Result recipeDetail(int recipeId);
    //创建菜谱


}