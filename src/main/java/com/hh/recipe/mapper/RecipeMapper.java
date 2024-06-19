package com.hh.recipe.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.recipe.domain.po.Recipe;
import com.hh.recipe.domain.vo.RecipeDetailVo;
import com.hh.recipe.domain.vo.ShowRecipeVo;

import java.util.ArrayList;


public interface RecipeMapper extends BaseMapper<Recipe> {


    RecipeDetailVo recipeDetail(int recipeId);


    ArrayList<ShowRecipeVo> showRecipeByRecipeName(String recipeName);

    ArrayList<ShowRecipeVo> showRecipeByIngredientName(String ingredientName);

    ArrayList<ShowRecipeVo> showRecipeByCategoryName(String categoryName);

    ArrayList<ShowRecipeVo> readRecipeLikesByRecipeIdRecipe(Integer userId);

    ArrayList<ShowRecipeVo> recipeFavoritesByRecipeId(Integer userId);

    Integer favoritesByRecipeId(int recipeId);

    Integer likesByRecipeId(int recipeId);

    ArrayList<ShowRecipeVo> popularFavorites();

    ArrayList<ShowRecipeVo> popularLikes();
}