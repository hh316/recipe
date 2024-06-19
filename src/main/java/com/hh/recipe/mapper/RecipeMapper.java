package com.hh.recipe.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.recipe.domain.po.Recipe;
import com.hh.recipe.domain.vo.FavoritesAndLikeRecipeVo;
import com.hh.recipe.domain.vo.RecipeDetailVo;

import java.util.ArrayList;


public interface RecipeMapper extends BaseMapper<Recipe> {


    RecipeDetailVo recipeDetail(int recipeId);


    ArrayList<RecipeDetailVo> recipeDetailByRecipeName(String recipeName);

    ArrayList<RecipeDetailVo> recipeDetailByIngredientName(String ingredientName);

    ArrayList<RecipeDetailVo> recipeDetailByCategoryName(String categoryName);

    ArrayList<FavoritesAndLikeRecipeVo> readrecipeLikesByRecipeIdRecipe(Integer userId);

    ArrayList<FavoritesAndLikeRecipeVo> recipeFavoritesByRecipeId(Integer userId);
}