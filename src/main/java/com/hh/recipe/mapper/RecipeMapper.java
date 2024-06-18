package com.hh.recipe.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.recipe.domain.po.Recipe;
import com.hh.recipe.domain.vo.FavoritesRecipeVo;
import com.hh.recipe.domain.vo.RecipeDetailVo;

import java.util.ArrayList;


public interface RecipeMapper extends BaseMapper<Recipe> {

    //查询收藏菜谱
    ArrayList<FavoritesRecipeVo> readRecipe(Integer userId);

    RecipeDetailVo recipeDetail(int recipeId);
}