package com.hh.recipe.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hh.recipe.domain.dto.CreateRecipeDto;
import com.hh.recipe.domain.po.Recipe;
import com.hh.recipe.utils.Result;


public interface RecipeService extends IService<Recipe> {
    //创建菜谱
    Result create(CreateRecipeDto recipeDto);


    Result recipeDetail(int recipeId);


    Result recipeDetailByRecipeName(String recipeName);

    Result recipeDetailByIngredientName(String ingredientName);

    Result recipeDetailByCategoryName(String categoryName);

    Result recipeLikesByRecipeId();

    Result recipeFavoritesByRecipeId();
}